# Candidate Profile Builder

## Overview
This project builds a canonical candidate profile by combining data from:
- recruiter.csv (Structured)
- resume.txt (Unstructured)

## Features
- Parse CSV
- Parse Resume
- Normalize phone numbers
- Normalize emails
- Normalize skills
- Merge candidate data
- Track provenance
- Generate output.json

## Technologies
- Java
- Spring Boot
- Maven
- Jackson
- Apache Commons CSV

## How to Run

```bash
mvn spring-boot:run
```

## Output
The application generates `output.json`.