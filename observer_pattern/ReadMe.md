# Observer Pattern

The **Observer Pattern** is a behavioral design pattern that establishes a **one-to-many dependency** between objects.  
In this pattern:  

- Some objects act as **Observables (Subjects)**.  
- Other objects act as **Observers**, subscribing to receive updates.  
- Whenever an `Observable` changes state, all its subscribed `Observers` are **notified automatically**.  

---

## Problem Statement  

Consider a **Weather Station** system:  

- Multiple services like `Temperature Sensors` or `Rainfall Predictors` generate updates.  
- These updates must be communicated to various clients like `Mobiles`, `Big Screens`, or `Bots`.  

Without the Observer Pattern, services would need to directly manage all clients, leading to **tight coupling** and poor scalability.  


## Try It Out  

To run the project:  

```bash
java Main.java
```

---

## Solution  

This project demonstrates the Observer Pattern by modeling the Weather Station scenario.  

- Services (`TemperatureSensorService`, `RainfallPredictorService`) act as **Observables**.  
- Clients (`Mobile`, `BigScreen`, `Bots`) act as **Observers**.  
- Observers can **subscribe/unsubscribe** dynamically, and will automatically be notified of updates.  

### UML Design  

![Design-Image](https://github.com/ashishjain0338/lld_pattern_theory/blob/main/images/Observer_Pattern_Weather_Station.png)  

---

## Benefits  

1. **Extensibility** → New observer types (e.g., `SmartWatch`) can be added without modifying existing services.  
2. **Loose Coupling** → Observables manage subscriptions but don’t need to know details of observers.  
3. **Automatic Notifications** → Any service update is automatically propagated to all subscribed observers.  
4. **Open/Closed Principle** → System is open for extension but closed for modification.  

---

## Old Design

![Design-Image](https://github.com/ashishjain0338/lld_pattern_theory/blob/main/images/Observer_Pattern_Weather_Station_Old.png) 

---
### Key Differences (Old vs latest)
1. `WeatherStation` acts as the central entity/ manager managing the Observerable and Publisher (subscribers) services, making it very tightly coupled; any extension (eg, adding `humidityService` as observable) would mean the change MUST go through WeatherStation. This is avoided in `latest-design` where `Observables` itself manages the logic to add/remove/notify subscribers.

---

## FYI: Full UML Design With Runner
![Design-Image](https://github.com/ashishjain0338/lld_pattern_theory/blob/main/images/Observer_Pattern_Weather_Station_with_TestCases.png) 
