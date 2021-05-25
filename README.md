# LOGIC Counter
***
This project is part of GlobalLogic recruitment process.

### The aim of the task:
For given the set of characters read an input, identify words which contains any of the LOGIC characters and prints the frequency of those
characters.
 
### Technology stack:
  - Java 11
  - Maven
  - JUnit5

### Example

###### Simple input

Input: "I love to work in global logic!"

Output:
```
{(i), 1} = 0.07 (1/15)
{(i), 2} = 0.07 (1/15)
{(o), 2} = 0.07 (1/15)
{(o), 4} = 0.07 (1/15)
{(l, o), 4} = 0.13 (2/15)
{(l, o, g), 6} = 0.27 (4/15)
{(l, o, g, i, c), 5} = 0.33 (5/15)
TOTAL Frequency: 0.63 (15/24)
```

###### Empty input

Input: ""

Output:
```
Empty phrase
```

###### Unique combination of chars and same length words

Input: "plate level"

Output:
```
{(l), 5} = 1.00 (3/3)
TOTAL Frequency: 0.30 (3/10)
```
