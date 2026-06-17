# Advanced Virtual Pet Simulator (OOP)

This desktop console application is a fully realized **Virtual Pet Simulator** developed as a core assessment for the **Object-Oriented Programming (OOP)** module of my Bachelor of Science (BSc) in Computing at **Arden University (Manchester)**.

The project demonstrates a high-level mastery of software engineering design patterns, mapping out real-world entity behaviors into a scalable, robust, and clean Java architecture.

---

## Software Engineering & OOP Pillars Applied

* **Abstraction (`Abstract Class`):** Architectural design utilizing a base `Pet` abstract class to enforce structural blueprints across all animal variants while preventing direct instantiation.
* **Inheritance Hierarchy:** Specialized behavior propagation splitting the abstract framework into distinct concrete subclasses: `Dog`, `Cat`, `Fish`, and `Horse`.
* **Polymorphism:** Method overriding ensuring that interactions like `feed()`, `play()`, and sound triggers respond dynamically based on the execution runtime object type.
* **Strict Encapsulation:** Safe object-state isolation. Core vitals (Happiness, Energy, Hunger, Anger, and Health) are strictly modified through controlled setter methodologies and logic boundaries.
* **Advanced State Machine Execution:** Dynamic simulation logic managing algorithmic thresholds for state mutations, such as entering a **Sick State** or executing operational parameters during **Death Handling**.

---

## Core Features & Game Mechanics

1.  **User-Pet Interaction Ecosystem:** Users can register profiles, adopt multiple animals, feed them, play interactive routines, and manage their general well-being.
2.  **Dynamic Lifecycle & Vitals Simulation:** Every action triggers mathematical mutations in the pet's internal vitals, modifying behavioral metrics in real time.
3.  **Medical & Threat Triggers:** If hunger or energy levels break critical thresholds, the engine pushes the entity into an active illness loop requiring immediate system intervention before triggering a permanent game-over state.

---

## Repository Blueprint

```text
├── src/
│   ├── Pet.java               # Base abstract superclass mapping shared vitals
│   ├── Dog.java               # Dog entity with polymorphic overrides
│   ├── Cat.java               # Cat entity with custom behavioral logic
│   ├── Fish.java              # Fish entity optimized for aquatic behaviors
│   ├── Horse.java             # Horse entity managing high-energy attributes
│   ├── User.java              # User simulation profile managing multiple pets
│   └── VirtualPetGame.java    # Main driver application and menu runtime controller
└── README.md                  # Comprehensive portfolio documentation
