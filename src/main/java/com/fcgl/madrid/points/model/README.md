# Database
A diagram explanation can be found in the same directory `db_diagram.png`.

### Action

`points` are awarded and added when an `Action` occurs.

```java
private Long id;
private String description;
private int points;
```



### Trophy

A trophy is awarded if the action `action` happens for `actionCount` times. The `numberOfPoints` is added to the `UserPoint`'s `totalPoints`.

```java
private Long id;
private int numberOfPoints;
private String imageFileLocation;
private String description;
private int actionCount;
private Action action;
```



### UserAction

`count` keeps track of how many times a user with the `userId` has performed the `action`.

```java
private Long id;
private Long userId;
private Action action;
private int count;
```



### UserPoint

`totalPoints` keeps track of all points the user has aquired through:

1. Performing an action: `Action`'s `points`.
2. Earning a trophy: `Trophy`'s `numberOfPoints`.

```java
private Long id;
private Long userId;
private int totalPoints;
private int tournamentPoints;
```



### UserTrophy

`count` keeps track of how many times a `trophy` was earned by a user having `userId`.

```java
private Long id;
private Long userId;
private Trophy trophy;
private int count;
```

