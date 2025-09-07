# Decorator Pattern

1. The Decorator Pattern allows you to dynamically add new features to a class without modifying its original implementation.
2. A decorator does not change the base behavior of the class; instead, it wraps the original object and enhances its functionality.
3. It works by taking the object as input, wrapping it inside a decorator, and returning the wrapped object.

```java
  Decorator1(Decorator2(BaseClass))
```
4. When you call a method on the final object, the call first goes through the outermost decorator (`Decorator1`), then proceeds inward through other decorators, and finally reaches the base class (if invoked by the decorators).


## In Theory:
1. The Decorator Pattern is a structural design pattern that lets you dynamically add new behavior to objects at runtime without altering their class.
2. Instead of subclassing for every new feature combination, you wrap objects in decorator classes that implement the same interface.
3. Each decorator can extend or modify behavior while still looking like the original object to the outside world.

## Problem Statment:
We want to build an Email Notification system where emails can have additional features such as:
1. Attachments (files, images, etc.)
2. Compression (to reduce size before sending)
3. Encryption (to secure the content)

The challenge is that we don’t want to create separate subclasses for every possible combination (e.g., `TextEmailWithAttachmentAndEncryption`, `TextEmailWithCompressionOnly`, etc.).
That approach would lead to class explosion and become hard to maintain when new features are added.

Instead, we need a flexible and scalable design that allows us to `dynamically add or combine features` (decorators) at `runtime`, without modifying the core email class.

## Try the project
```bash
java Main.java
```

## Solution
![Design-Image](https://github.com/ashishjain0338/lld_pattern_theory/blob/main/images/Decorator_Pattern_Email_Notification_System.png)

---
### Benefits Provided
1. Flexibility at Runtime: You can add/remove features like encryption, compression, or attachments dynamically without changing core classes.
2. Single Responsibility: Each decorator handles one concern (e.g., compression, encryption), making the design cleaner and easier to maintain.
3. Avoids Class Explosion: Without decorators, you’d need classes like EncryptedCompressedEmailWithAttachment. Decorators let you combine behaviors without creating exponential subclasses.
4. Open/Closed Principle: Classes are open for extension (via new decorators) but closed for modification (base TextEmail remains untouched).

## 
