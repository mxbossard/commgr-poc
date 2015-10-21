package fr.mby.commgr;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.RandomUtils;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.mby.commgr.domain.Account;
import fr.mby.commgr.domain.Community;
import fr.mby.commgr.domain.Membership;
import fr.mby.commgr.domain.Person;
import fr.mby.commgr.domain.Season;
import fr.mby.commgr.repositories.AccountRepository;
import fr.mby.commgr.repositories.CommunityRepository;
import fr.mby.commgr.repositories.MembershipRepository;
import fr.mby.commgr.repositories.PersonRepository;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.company.Company;

@SpringBootApplication
public class Application {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);

	private static final Fairy FAIRY = Fairy.create();

	private static final int LOAD_FACTOR = 10;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Bean
	CommandLineRunner initAccounts(final AccountRepository accountRepository) {
		return (args) -> {
			Account admin = new Account();
			admin.setUsername("admin");
			admin.setPassword("admin");
			//admin.setPerson(buildRandomPerson());
			
			accountRepository.save(admin);
		};
	}

	@Bean
	public CommandLineRunner initCommgrDomain(CommunityRepository communityRepo, AccountRepository accountRepo, PersonRepository personRepo,
			MembershipRepository membershipRepo) {
		return (args) -> {
			LOG.info("Initializing domain with a load factor of [{}] ...", LOAD_FACTOR);
			
			for (int k = 0; k < LOAD_FACTOR; k++) {
				// Build some communities
				Community community = buildRandomCommunity();

				// Build seasons
				int seasonCount = RandomUtils.nextInt(1, 5);
				Set<Season> seasons = new HashSet<>();
				for (int i = 0; i < seasonCount; i++) {
					Season season = buildRandomSeason(community);
					seasons.add(season);
				}

				DateTime randomDate = FAIRY.dateProducer().randomDateInTheFuture(1);
				for (Season season : seasons) {
					season.setValidTo(randomDate);
					randomDate = randomDate.minusDays(364);
					season.setValidFrom(randomDate);
					season.setName(String.valueOf(season.getValidFrom().getYear()));
					randomDate = randomDate.minusDays(1);
				}
				seasons.iterator().next().setActive(true);
				community.setSeasons(seasons);

				communityRepo.save(community);

				// Build people
				int peopleCount = RandomUtils.nextInt(1, 100);
				for (int i = 0; i < peopleCount; i++) {
					io.codearte.jfairy.producer.person.Person randPers = FAIRY.person();
					
					Account account = buildRandomAccount(randPers);
					Person person = buildRandomPerson(randPers);
					account.setPerson(person);
					
					accountRepo.save(account);

					Season currentSeason = seasons.iterator().next();
					Membership membership = buildRandomMembership(account, currentSeason);

					membershipRepo.save(membership);
				}
			}
		};
	}

	public static Membership buildRandomMembership(Account account, Season season) {
		Membership membership = new Membership();

		membership.setSeason(season);
		membership.setAccount(account);
		membership.setValidFrom(
				FAIRY.dateProducer().randomDateBetweenTwoDates(season.getValidFrom(), season.getValidTo()));
		membership.setValidTo(null);
		membership.setNote(FAIRY.textProducer().paragraph(2));

		return membership;
	}

	public static Season buildRandomSeason(Community community) {
		Season season = new Season();

		DateTime randomDate = FAIRY.dateProducer().randomDateInTheFuture(1);
		season.setValidTo(randomDate);
		randomDate = randomDate.minusDays(364);
		season.setValidFrom(randomDate);
		season.setName(String.valueOf(season.getValidFrom().getYear()));
		season.setNote(FAIRY.textProducer().paragraph(3));
		season.setCommunity(community);
		
		return season;
	}

	public static Community buildRandomCommunity() {
		Community community = new Community();

		Company company = FAIRY.company();

		community.setName(company.name());
		community.setEmail(company.email());
		community.setDescription(FAIRY.textProducer().paragraph(5));
		community.setNote(FAIRY.textProducer().paragraph(2));

		return community;
	}

	public static Person buildRandomPerson(io.codearte.jfairy.producer.person.Person fp) {
		Person person = new Person();

		person.setFirstName(fp.firstName());
		person.setLastName(fp.lastName());
		person.setDateOfBirth(fp.dateOfBirth());

		return person;
	}

	public static Account buildRandomAccount(io.codearte.jfairy.producer.person.Person fp) {
		Account account = new Account();

		account.setEmail(fp.email());
		account.setUsername(fp.username());
		account.setPassword(fp.password());

		return account;
	}
	
}