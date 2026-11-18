# PROG6112 Java Exam Codes (2022–2025)

16 topic-based, commented Java study templates based on the supplied PROG6112 exam revision presentation and 2022–2025 answer guide. These are **practice examples**, not answers to every exam question. Adapt class names, exact method signatures, data, VAT rates, file names, validation and output to the actual question. Follow your institution's rules for AI assistance and attribution.

## Topics

- `01-One-Dimensional-Arrays`
- `02-Two-Dimensional-Arrays`
- `03-Total-Average-Max-Min`
- `04-Top-Performer`
- `05-Interfaces-And-Classes`
- `06-JUnit-Testing`
- `07-Scanner-Input`
- `08-Input-Validation`
- `09-VAT-And-Commission`
- `10-Swing-GUI`
- `11-Button-Events`
- `12-ComboBoxes-And-Lists`
- `13-Menu-Bar`
- `14-Save-Text-Files`
- `15-Read-Text-Files`
- `16-Sales-Limit`

## How to run in NetBeans

1. Open NetBeans and create a Java with Maven > Java Application project.
2. For a console topic, copy its `.java` file into Source Packages (keep the package line NetBeans generates, if any).
3. Run the class with **Shift+F6**. Each folder is a separate example; do not paste every class into one file.
4. For the Swing GUI examples (topics 10–13), run the corresponding class. They create their own windows in code. If you use the NetBeans GUI designer, transfer only the relevant logic into your generated JFrame; do not edit locked generated code.
5. Topic 14 writes `report.txt` to the working directory. Run topic 14 before topic 15, which reads that file.
6. Topic 05 provides `ICalculations.java` and `Calculations.java`. Topic 06 is a JUnit 5 test for those two files. To test, copy all three files into a Maven project, with the test in `src/test/java`, add JUnit 5 to the project, then run tests.

## JUnit 5 Maven dependency

Add this inside `<dependencies>` in your `pom.xml` if JUnit 5 is not already present:

```xml
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <version>5.11.4</version>
  <scope>test</scope>
</dependency>
```

Use a current Maven Surefire plugin version supporting JUnit 5 (e.g. 3.5.2) if needed.

## Exam reminders

- The supplied 2025 revision covers 2D array reports, interfaces, JUnit, Swing, menus and text-file output.
- Earlier papers also cover validation, commission, VAT, combo boxes and sequential files.
- Use exact names required by the paper, comment your own logic and test the program.
- Do not upload the original lecturer PDF or slides to a public repository without permission.
