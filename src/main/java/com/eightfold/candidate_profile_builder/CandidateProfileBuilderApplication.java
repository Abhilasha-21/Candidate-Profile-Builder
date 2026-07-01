package com.eightfold.candidate_profile_builder;

import com.eightfold.candidate_profile_builder.config.ProjectionEngine;
import com.eightfold.candidate_profile_builder.merger.CandidateMerger;
import com.eightfold.candidate_profile_builder.model.Candidate;
import com.eightfold.candidate_profile_builder.model.Provenance;
import com.eightfold.candidate_profile_builder.model.Skill;
import com.eightfold.candidate_profile_builder.normalizer.EmailNormalizer;
import com.eightfold.candidate_profile_builder.normalizer.PhoneNormalizer;
import com.eightfold.candidate_profile_builder.normalizer.SkillNormalizer;
import com.eightfold.candidate_profile_builder.parser.CsvParser;
import com.eightfold.candidate_profile_builder.parser.ResumeParser;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CandidateProfileBuilderApplication {

	public static void main(String[] args) throws Exception {

		// ===========================
		// STEP 1 : Parse CSV
		// ===========================

		CsvParser csvParser = new CsvParser();
		Candidate csvCandidate = csvParser.parse();

		System.out.println("===== CSV DATA =====");
		System.out.println("Name      : " + csvCandidate.getFullName());
		System.out.println("Email     : " + csvCandidate.getEmails());
		System.out.println("Phone     : " + csvCandidate.getPhones());
		System.out.println("Headline  : " + csvCandidate.getHeadline());

		// ===========================
		// STEP 2 : Parse Resume
		// ===========================

		ResumeParser resumeParser = new ResumeParser();
		Candidate resumeCandidate = resumeParser.parse();

		System.out.println("\n===== RESUME DATA =====");
		System.out.println("Name      : " + resumeCandidate.getFullName());
		System.out.println("Headline  : " + resumeCandidate.getHeadline());

		System.out.println("Skills :");

		for (Skill skill : resumeCandidate.getSkills()) {
			System.out.println(" - " + skill.getName());
		}

		// ===========================
		// STEP 3 : Normalize CSV
		// ===========================

		csvCandidate.getEmails().set(
				0,
				EmailNormalizer.normalize(csvCandidate.getEmails().get(0))
		);

		csvCandidate.getPhones().set(
				0,
				PhoneNormalizer.normalize(csvCandidate.getPhones().get(0))
		);

		// ===========================
		// STEP 4 : Normalize Skills
		// ===========================

		for (Skill skill : resumeCandidate.getSkills()) {

			skill.setName(
					SkillNormalizer.normalize(skill.getName())
			);

		}

		// ===========================
		// STEP 5 : Merge
		// ===========================

		CandidateMerger merger = new CandidateMerger();

		Candidate finalCandidate =
				merger.merge(csvCandidate, resumeCandidate);

		// ===========================
		// STEP 6 : Final Candidate
		// ===========================

		System.out.println("\n===== FINAL CANDIDATE =====");

		System.out.println("Candidate ID : " + finalCandidate.getCandidateId());

		System.out.println("Name         : " + finalCandidate.getFullName());

		System.out.println("Email        : " + finalCandidate.getEmails());

		System.out.println("Phone        : " + finalCandidate.getPhones());

		System.out.println("Headline     : " + finalCandidate.getHeadline());

		System.out.println("\nSkills:");

		for (Skill skill : finalCandidate.getSkills()) {

			System.out.println(
					skill.getName()
							+ " (Confidence : "
							+ skill.getConfidence()
							+ ")"
			);

		}

		// ===========================
		// STEP 7 : Provenance
		// ===========================

		System.out.println("\n===== PROVENANCE =====");

		for (Provenance provenance : finalCandidate.getProvenance()) {

			System.out.println(
					provenance.getField()
							+ " --> "
							+ provenance.getSource()
			);

		}

		// ===========================
		// STEP 8 : Read Config
		// ===========================

		System.out.println("\n===== CONFIG FIELDS =====");

		ProjectionEngine projectionEngine = new ProjectionEngine();

		projectionEngine.generateOutput(finalCandidate);

		System.out.println("\nAssignment Executed Successfully.");
	}
}