# BMI calculator project

This project helps to look on high level how unit testing is done for a java program using junit framework.

# Run the junit tests use: 
```mvn test```

# Generate EvoSutie test cases:
```
java -jar lib\evosuite-1.2.0.jar -class org.example.WeightHelper -projectCP target\classes
```
1. Had to use the jar file as there were no usable lib in maven central for evosuite.
2. After running the command, "WeightHelper_ESTest.java" got generated in new folder "evosuite-tests".

# Run MuJava
1. Set up the env variables in the local machine.
2. Set up folder structure with needed jar and config files.
3. Run:
```
java -cp "C:\MuJava\mujava.jar;C:\MuJava\openjava.jar;" mujava.gui.GenMutantsMain
```

