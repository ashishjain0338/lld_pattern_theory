# Strategy Pattern

Different strategies mean different implementations of some functionality, which allows switching between strategies on `runtime`.
Example: PaymentStrategy, BeamFormingStrategy

Key Idea: Define a family of algorithms, encapsulate each one, and make them interchangeable.

## Problem Statement:
---
How do you design a navigation system (`bike, car, walk`) that can dynamically choose between multiple route-finding approaches (`shortest time, shortest distance, scenic`) without bloating the navigation classes or hardcoding conditional logic?

## Try the project
```bash
java Main.java
```
## Solution
---
![image-text](https://github.com/ashishjain0338/lld_pattern_theory/blob/main/images/Navigation_With_Route_Strategy.png)

## Benefits
---
1. If you don’t use Strategy Pattern, you’d end up with `big if-else` or `switch blocks` inside Navigation (e.g., if routeType == Scenic then ... else if ...), making the system rigid and hard to extend.
2. Flexibility: Each Navigation object can swap its RouteStrategy at runtime (`changeRouteStrategy()`), e.g., a user can shift from scenic to shortest-time without rewriting logic.
3. Open/Closed Principle: Adding a new strategy (say `TollAvoidanceRouteFinding`) doesn’t require changing existing navigation code—just add a new class.
4. Clean Separation: Navigation (context) is `decoupled` from route-finding logic (strategies).

---
## FYI: Full UML Design With Runner
![design-image](https://github.com/ashishjain0338/lld_pattern_theory/blob/main/images/Navigation_With_Route_Strategy_And_Testcase.png)
