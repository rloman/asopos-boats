Welcome
=======

News Flash
==========

-   Released version v1.6.0

Release notes
=============

-   Add section numbering

-   Add topic: Regular Expressions

Topic: final
============

Introduction
------------

During this section we will learn working with the keyword **final**

What you will learn
-------------------

-   Why and when to use it

-   How to use it

Why: final
----------

-   When you want a local variable to be unchangeable / constant after creation

-   When you want a field to be unchangeable / constant after creation

-   When you want to prevent a method to be overridden in a subclass

-   When you want to prevent that someone inherits from a class

What: final
-----------

    final int age =45;
    age++; // compile error

    package nl.capgemini.diving.finaltraining;

    public class Hockeyer {

        private final String name; // error if NOT FILLED with ALL constructors


        public Hockeyer() {
            super();
            this.name = null;
        }

        public Hockeyer(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public final void play() {

        }

    }

> **Warning**
>
> a **final** field MUST have a value after the constructor is ran, no matter what constructor!

> **Tip**
>
> If you want a final field to be null you can assign null explicit to it, as shown above on the no-arg constructor

    package nl.capgemini.diving.finaltraining;

    public class Hockeyer {

        public final void play() {

        }

    }

    class ChildHockeyer extends Hockeyer  {

            @Override
                    public void play() { // compile error since Hockeyer::play is final method

            }
    }

    package nl.capgemini.diving.finaltraining;

    public final class ChildHockeyer extends Hockeyer  {

    }

    class DummyHockery extends ChildHockeyer { // compile error

    }

Topic: Try with Resources
=========================

Assignment: Try with Resources
------------------------------

*Target*.  
To learn to work with the **try with resources** paradigm; using the **Autocloseable** interface (Java 7)

*Roadmap*.  
During this assignment you will implement a Drawer which automatically closes

-   I have a drawer class

    -   which implements a specific interface

-   I have a class with a main method

-   which creates an instance of the Drawer

-   I use the drawer in a try with resources block

-   and the drawer goes out of scope

-   the method **void close()** is invoked

-   then the message "Drawer is automatically closed" is printed to the console

> **Tip**
>
> See the code below to have a starter

    package nl.smulweb.foodcorner.autocloseable.assignment;

    import java.util.HashSet;
    import java.util.Set;

    public class Drawer /* implements ??? */{

       private boolean open;

       private Set<String> names = new HashSet<String>();

       public Drawer() {
          this.open = true;
       }

       public void add(String name) {
          this.names.add(name);
       }

    //   ??? add a method

    }

    package nl.smulweb.foodcorner.autocloseable.assignment;

    import java.io.IOException;

    public class Application {

       public static void main(String[] args) throws IOException {

          try(???) {

             String name ="Piet";
             String otherName = "Jan";
             String oneMore = "Karel";

             drawer.add(name);
             drawer.add(otherName);
             drawer.add(oneMore);

          }

       }

    }

:!solution\_autocloseable:

Topic: Mockito
==============

Assignment: Mockito
-------------------

*Target*.  
To learn to work with Mockito

*Roadmap*.  
During this assignment you will create two tests. One for SkiStore::sell(Skies) and one for SkiStore::checkForDamge(Skies) and you will **mock out** the SkiService

    package nl.example.app.store;

    import nl.example.app.model.Skies;
    import nl.example.app.service.SkiService;

    public class SkiStore {

       private SkiService skiService;

       public double rent(Skies skies) {

          return this.skiService.rent(skies);
       }

       public boolean checkForDamage(Skies skies) {
          return this.skiService.checkForDamage(skies);
       }
    }

    package nl.example.app.service;

    import nl.example.app.model.Skies;

    public interface SkiService {

       double rent(Skies skies);
       boolean checkForDamage(Skies skies);
    }

-   I add the dependency to Mockito core (using ["http://mvnrepository.com", window="\_blank"](http://mvnrepository.com))

<!-- -->

    package nl.example.app.store.mockito.assignment;

    import org.junit.Assert;
    import org.junit.Test;

    import nl.example.app.model.Skies;
    import nl.example.app.service.SkiService;
    import nl.example.app.store.SkiStore;

    //@RunWith(???)
    public class SkiStoreTest {

       // inject some here???
       private SkiStore skiStore;

      // mockit
       private SkiService service;

    //   @Test
       public void testRent() {

          // Given (Arrange)
          Skies skies = new Skies();

    //      Mockito.when(??)))
    //      .thenReturn(3.5);


          // When (Act)
          double resultOfRent = this.skiStore.rent(skies);


          // Then (Assert)
    //      Mockito.???(this.service).rent(Mockito.any(Skies.class));

          Assert.assertEquals(3.5, resultOfRent, 0.1);
       }
    }

-   sell

-   checkForDamage

*Validation*.  
this might be optional

:!solution\_mockito:

Topic: Navigable Set
====================

Introduction
------------

During this section we will learn to work with a Handy Map, the navigable set

What you will learn
-------------------

-   That you can use a navigable set to find a value below or up a given value

-   That you can use it for example to implement a time based schedule for a train

-   That sometimes trains run on time :-)

Why: Navigable Set
------------------

A navigable Set is very handy for having some values in the Set and finding and upper or lower value.

Of course, the principle of having a train schedule.

We know that the train leaves at some times and we want to find the next time that the train leaves.

What and How: Navigable Set
---------------------------

    NavigableSet<String> schedule = new TreeSet<>();

Assignment: Navigable Set
-------------------------

*Target*.  
To learn to work with the Navigable Set

*Roadmap*.  
During this assignment you will implement a trainschedule application

    package nl.example.app.navigable.assignment;

    import java.util.Arrays;
    import java.util.NavigableSet;
    import java.util.TreeSet;

    public class TrainSchedule {

       private NavigableSet<String> schedule; // add a concrete class

       public TrainSchedule() {
          // add some times
          this.schedule.addAll(Arrays.asList("10:30", "09:30", "13:15", "16:30"));
       }

       public String getTimeBefore(String time) {
          return "Something";

       }

       public String getTimeAfter(String time) {
          return "also something";
       }

    }

-   I invoke the findLower or Higher

-   I expect the lower and higher time of the train leave time to be printed to the console

> **Warning**
>
> Please implement unittests before (TDD) or after (not TDD but OK) in your app

:!solution\_navigable\_set:

Topic: Queue | ArrayDeque
=========================

Introduction
------------

This section will introduce the queue in general and the ArrayDeque implementation of Queue especially

What you will learn
-------------------

-   What the principles of a Queue are

-   And what the principle of an ArrayDeque is

-   How to use them

Why: Queue | ArrayDeque
-----------------------

You use a queue want - of course - you want the principle of a queue

Assignment: Queue | ArrayDeque
------------------------------

*Target*.  
During this assignment you learn to work with an ArrayDeque (after following the book this should be possible)

-   In this assignment you will create an ArrayDeque with the following principles

    -   when you add a Task it is added to the end of the queue

    -   when you add a Task with a personName of *Willem-Alexander* it is placed at the top of the queue

<!-- -->

    package nl.example.app.queue.assignment;

    import java.util.Collection;

    public class Scheduler {


       //???

       public void add(Task t) {

          if("Willem-Alexander".equals(t.getPersonName())) {
          }
          else {
          }

       }

       public void add(Collection<Task>tasks) {
          tasks.forEach(this::add);
       }

       public void execute() {
    //      while(!taskQueue.isEmpty()) {
    //      ????
    //         victim.execute();
    //      }
       }

    }

    package nl.example.app.queue.assignment;

    import java.util.Arrays;

    public class Application {

       public static void main(String[] args) {


          Scheduler s = new Scheduler();

          Task ray = new Task("Ray");
          Task w = new Task("Willem-Alexander");
          Task b = new Task("Anne");

          s.add(Arrays.asList(ray, w, b));

          s.execute();

       }

    }

-   I invoke the Application::main

-   I see that Willem-Alexander his task(s) are executed before other tasks

:!solution\_arraydeque:

Topic: Binary Trees
===================

We will (have to ) handle binary trees in the plenair session

Topic: Binary Search
====================

    package nl.example.app.binarysearch.solution;

    import java.util.Arrays;
    import java.util.List;

    public class Application {

       public static void main(String[] args) {

          List<Integer> numbers = Arrays.asList(0,1,1,2,3,5,8,13,21,34,55,89);

          int result = Arrays.binarySearch(numbers.toArray(new Integer[0]), 34);

          System.out.println(result);

          result = Arrays.binarySearch(numbers.toArray(new Integer[0]), 45);

          System.out.println(result);

       }

    }

Assignment
----------

Explain for yourself why there might be a negative number of the result in the code above?

Topic: Design Patterns
======================

Introduction
------------

In the previous section we learned that we can program away and that is good :-) But sometimes it is good to know that there are already **best practices** for several code challenges we are facing | are going to face and those **best practices** are called **Design Patterns**

A subset of **Design Patterns** (4 of them) will be the subject of this section

What you will learn
-------------------

-   What design patterns are

-   When to use them

-   Where to find them

-   How to read a book about them

-   When not to use them

-   Where to find code about them! :-)

Why: Design Patterns
--------------------

Simply said, since inventing the wheel is not what we want!

When: Design Patterns
---------------------

You use design patterns when you see a **pattern** in the problem you are solving! So … at first you have to know what kind of **patterns** there are and when you find that \_he, that problem looks like a design pattern\* then, you can use it

What: Design Patterns
---------------------

Design Patterns are simply said best practices, as mentioned above!

How: Design Patterns
--------------------

The how of design patterns? Well read this books

-   Design Patterns: The Gang of Four

-   Head First Design Patterns

Tips: Design Patterns
---------------------

*Design pattern flue*.  
Be aware of the design pattern flue. It is good to use design pattern but use them wisely. Not every problem should directly be solved by using design patterns. Even sharper; do not use design patterns directly but just start coding and while coding you see … hay I see a design pattern which helps me. Than kick that design pattern in.

-   ["Head First Design Patterns book by Eric Freeman (funny reading)", window="\_blank"](https://www.amazon.de/First-Design-Patterns-Brain-Friendly/dp/0596007124/ref=sr_1_1?ie=UTF8&qid=1543568561&sr=8-1&keywords=head+first+design+patterns)

-   ["The Gang of four Book (dryer reading)", window="\_blank"](https://nl.wikipedia.org/wiki/Design_Patterns)

-   ["Some Java code for design patterns written by the author using the Head First book", window="\_blank"](https://github.com/rloman/design-patterns)

Follow-Up: Design Patterns
--------------------------

That was a very short intro to design pattern. Talking about it will help!

-   Iterator

-   Adapter

-   Singleton

-   Template

Topic: Design Pattern: Builder
==============================

Introduction
------------

In the previous module we learned what the general principles are behind design patterns. Now it is time to dive into a handy and much used design pattern, the **Builder Pattern**

Learning objectives
-------------------

-   Describe why and when you should use the builder pattern

-   Describe what the builder pattern is consisted of

-   Describe how the builder pattern works

-   Implement the builder pattern into real live software

Why and When: Design Pattern: Builder
-------------------------------------

-   A lot of fields to set during construction

-   You want to be sure that the constructed object is in a valid state

-   You want to make live easier for your surrounding collega’s to make an instance of the object at hand

What: Design Pattern: Builder
-----------------------------

-   The object at hand is only created and able to be created(!) through the use of the builder for that object type

    -   e.g. for creating a Car we have a CarBuilder

-   There is a mandatory set of fields to send to the builder when creating the builder

-   There is an optional set of fields to send to the builder when mofifying the builder using **Fluent API**

-   When you have configured the builder itself, there is a **build** method to create the desired object

How: Design Pattern: Builder
----------------------------

-   The Builder itself is a **public static** inner class of the desired object

-   The Builder itself has a **public** constructor which receives only(!) the mandatory fields of the desired object

-   The builder has **Fluent Api** methods which set the optional fields of the to be created desired object

    -   e.g. builder.cc(500).tyres(4).roof(false)…

    -   this fluent api methods return the builder instance itself

-   Use of a private constructor in the desired object type which receives a builder instance

    -   The fields of the builder are than passed to the desired object

Instructor Demo: Design Pattern: Builder
----------------------------------------

-   How to use the builder pattern for a Car by implementing a CarBuilder

<!-- -->

    package nl.example.app.designpatterns.builder;


    /**
     * This class demonstrates the usage of the Builder pattern
     */
    public class Application {

        public static void main(String[] args) {
            // longer version
            {
                Car.CarBuilder builder = new Car.CarBuilder("Mercedes");
                builder.licensePlate("AABBCC");
                builder.cc(3500);

                Car car = builder.build();

                System.out.println(car);

                // print the hashCode to see the address of the Car instance
                // to show that the objects are different instances
                System.out.println("hashCode / address => "+car.hashCode());

                car = builder.build();

                System.out.println(car);

                // print the hashCode to see the address of the Car instance
                // to show that the objects are different instances
                System.out.println("hashCode / address => "+car.hashCode());
            }

            // shorter version
            {
                Car car = new Car.CarBuilder("Mercedes").licensePlate("AABBCC").cc(3500).build();
                System.out.println(car);
                // print the hashCode to see the address of the Car instance
                System.out.println("hashCode / address => "+car.hashCode());
            }
        }
    }

    package nl.example.app.designpatterns.builder;

    /**
     * This is the desired object, an instance of the Car class
     */
    public class Car {

        private String brand;
        private String licensePlate;
        private Engine engine;

        private Car(CarBuilder builder) {
            this.brand = builder.brand;
            this.licensePlate = builder.licensePlate;
            this.engine = new Engine(builder.cc);
        }

        public String getBrand() {
            return brand;
        }

        public String getLicensePlate() {
            return licensePlate;
        }

        public Engine getEngine() {
            return engine;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "brand='" + getBrand() + '\'' +
                    ", licensePlate='" + getLicensePlate() + '\'' +
                    ", engine=" + getEngine() +
                    '}';
        }

        /**
         * This is the inner class CarBuilder in the Car class
         */
        public static class CarBuilder {


            private String brand;
            private String licensePlate;
            private int cc;

            public CarBuilder(String brand) {
                this.brand = brand;
            }

            public CarBuilder licensePlate(String licensePlate) {
                this.licensePlate = licensePlate;

                return this;
            }

            public CarBuilder cc(int cc) {
                this.cc = cc;

                return this;
            }

            public Car build() {
                return new Car(this);
            }
        }
    }

### Conclusion

We use the builder pattern to create a complex object to prevent an illegal state of that object and to make live easier.

Exercise: Design Pattern: Builder
---------------------------------

-   Explain the why and when of the builder pattern

-   Explain what the builder pattern consist of

-   Implement the builder pattern

-   Having some basic Java knowledge

-   Having an IDE like Intellij or Eclipse

### Implement the Design Pattern: Builder

    package nl.example.app.designpatterns.builder.assignment;

    public class Vacation {

        private String destination;
        private double price;
        private int numberOfPeople;
        private Ticket ticket;

        public double getPrice() {
            return price;
        }

        public int getNumberOfPeople() {
            return numberOfPeople;
        }

        public Ticket getTicket() {
            return ticket;
        }

        public String getDestination() {
            return destination;
        }
    }

    package nl.example.app.designpatterns.builder.assignment;

    public class Ticket {

        private long id;
        private String person;

        public long getId() {
            return id;
        }

        // ...
    }

### Conclusion

*Create an Application class with a main method to create a **Vacation** object*.  
In this exercise, you set up basic examples of cluster routing intended for use with stateful and stateless deployments receiving traffic from inside or outside your cluster.

Bonus Exercise ???
------------------

You might add a bonus exercise here

(Optional) Uninstalling Design Pattern: Builder
-----------------------------------------------

Conclusion
----------

(conclusion of this module) and link to the next module

During this module we learned how to make … so that … we can

In the following module we will learn that we can (also) make use of …

Further reading
---------------

<table>
<tbody>
<tr class="odd">
</tr>
<tr class="even">
</tr>
<tr class="odd">
</tr>
<tr class="even">
</tr>
<tr class="odd">
</tr>
<tr class="even">
</tr>
</tbody>
</table>

Topic: Design Pattern: Iterator
===============================

Introduction
------------

In the previous section we learned that there are several kinds of Patterns. During this section we will learn a very much used and great design pattern: The Iterator pattern.

What you will learn
-------------------

-   What problem the Iterator pattern fixes for us

-   When to use it

-   How to implement it

Why and When: Design Pattern: Iterator
--------------------------------------

You use the Iterator Design pattern for the following reason \* you want to iterate over an object using the for-each / enhanced for loop but you are not a List or a Set

Then you use the iterator pattern

What: Design Pattern: Iterator
------------------------------

The Iterator pattern is a kind of way to add the possibility to iterate over an object which is than called an Iterable Object

How: Design Pattern: Iterator
-----------------------------

In several languages, there are several ways to implement the Iterator pattern. During this training we will use Java

-   add **implements Iterable** to your class

    -   add the Iterator iterator() method to your class since the Iterable interface demands it

-   interface with some methods

    -   boolean hasNext();

    -   E next();

So, simply said, or … return the Iterator from the Collections type (List, Set,…) or … return a class implementing the Iterator methods mentioned above

    package nl.example.app.iterator;

    import java.util.ArrayList;
    import java.util.Iterator;
    import java.util.List;

    public class Container implements Iterable<String> {

       private List<String> content = new ArrayList<>();

       public void add(String name) {
          this.content.add(name);
       }

       @Override
       public Iterator<String> iterator() {

          return this.content.iterator();
       }

    }

Assignment: Design Pattern: Iterator
------------------------------------

*Target*.  
To learn to work with the iterator pattern

*Roadmap*.  
During this assignment you will implement a **Fruitmand** class which implements the Iterable\<Fruit\> interface

    package nl.example.app.iterator.assignment;


    public class Application {

       public static void main(String[] args) {
          Fruit f = new Fruit("Apple");

          Fruitmand m = new Fruitmand();

          m.add(f);
          m.add(new Fruit("Pear"));
          m.add(new Fruit("Banana"));

          /*
          for(Fruit fruit: m) {
             System.out.println(fruit);
          }
          */
       }

    }

    package nl.example.app.iterator.assignment;


    public  class Fruit {

       private String name;


       public Fruit(String name) {
          this.name = name;
       }


       public String getName() {
          return name;
       }

       public void setName(String name) {
          this.name = name;
       }


       @Override
       public String toString() {
          return "Fruit [name=" + name + "]";
       }

    }

-   The Fruitmand class

:!solution\_fruitmand:

Bonus Assignment | Demo
-----------------------

    package nl.example.app.iterator;

    public class Application {

       public static void main(String[] args) {

          Iterable<Integer> squareIterable = new SquareIterator(0, 10);

          for (int square : squareIterable) {

             System.out.println(square);

          }

          for (int square : squareIterable) {


             System.out.println(square);

          }

       }

    }

    package nl.example.app.iterator;

    import java.util.Iterator;

    public class SquareIterator implements Iterable <Integer>, Iterator<Integer> {

       private int current;

       private int min;
       private int max;


       public SquareIterator(int min, int max) {
          this.min = min;
          this.max = max;
          this.current = min;
       }

       @Override
       public boolean hasNext() {

          return current < max ? true : false;
       }

       @Override
       public Integer next() {
         return current * current++;
       }

       @Override
       public Iterator<Integer> iterator() {
          return new SquareIterator(min, max);
       }
    }

-   Implement the Fibonacci or some other iterator???

-   n → Math.pow(n,3)???

-   n → Math.sqrt(n);

Conclusion
----------

(conclusion of this section) and link to next section During this section we learned how to make use of ther Iterator pattern. There are much more design patterns, one of them is the **Adapter** pattern which is the topic of the next section

Topic: Design Pattern: Adapter
==============================

Introduction
------------

In the previous section we learned that we have the Iterator pattern for iterating over an object. In the following section we will learn to use the Adapter pattern, which also is sometimes called a **Wrapper** (does it ring any bell now? :-))

What you will learn
-------------------

-   Why you would want to use the adapter pattern

-   When to use it

-   What it is and how to use it

Why and When: Design Pattern: Adapter
-------------------------------------

You use the Adapter pattern to **adapt** a class to a specific interface without changing that class to implement that interface. e.g. you might have a class A in a library which is unchangeable by you. You might have an interface I which is unchangeable by you and you want that class A to be able to pass using the interface I.

That is why you want to and should use the **Adapter pattern**

What: Design Pattern: Adapter
-----------------------------

-   an interface we want to have

-   an other class of an other interface type

-   a wrapper class (the solution)

How: Design Pattern: Adapter
----------------------------

Below you find an implemention of the adapter pattern where I want to map some WildTurkey class with corresponding interface type **Turkey** to a Duck interface type

    package nl.example.app.adapter;

    public interface Duck {

            void quack();
            void walk();

    }

    package nl.example.app.adapter;

    public interface Turkey {

            void walk();
            void gobble();

    }

    package nl.example.app.adapter;

    public class WildTurkey implements Turkey {

            @Override
            public void walk() {
                    System.out.println("Walking turkey ...");

            }

            @Override
            public void gobble() {
                    System.out.println("Gobble ... gobble ...");
            }

    }

    package nl.example.app.adapter;

    public class TurkeyAdapter implements Duck {
            private Turkey turkey;

            public TurkeyAdapter(Turkey turkey) {
                    this.turkey = turkey;
            }

            @Override
            public void quack() {
                    turkey.gobble();

            }

            @Override
            public void walk() {
                    turkey.walk();

            }
    }

            Turkey t= new WildTurkey();
            Duck d = new TurkeyAdapter(t);

            System.out.println(d.quack());

Assignment: Design Pattern: Adapter
-----------------------------------

*Target*.  
To learn working with the adapter pattern

*Roadmap*.  
During this assignment you will create a Pavo (Dutch: Pauw) interface and WildPavo class which implements the Pavo interface and map it to a Duck

*Steps*.  
Make a PavoAdapter (or PauwAdapter) to map a Pauw to a Duck

    package nl.example.app.adapter.solution;


    public interface Pavo {

       void run();
       void sound();

    }

    package nl.example.app.adapter.solution;


    public class WildPavo implements Pavo {

       @Override
       public void run() {

          System.out.println("Running Pavo (Pauw)");

       }

       @Override
       public void sound() {

          System.out.println("Te nauw!");

       }

    }

:!solution\_adapter:

Conclusion
----------

During this section we learned how to make good use of the **Adapter** pattern so that we can map a specific interface type to another interface type, which is in fact always the trigger to use this pattern

In the following section we will learn the (unrelated) Singleton pattern

Topic: Design Pattern: Singleton
================================

Introduction
------------

In the previous section we learned that we can iterate over an object using the **Iterator** pattern and we can adapt to an interface using the **Adapter** pattern.

In this section we will use the pretty much used **Singleton** pattern

What you will learn
-------------------

-   What the Singleton pattern is and how to use it

-   Why and When to use the Singleton pattern

Why and When: Design Pattern: Singleton
---------------------------------------

You use the Singleton pattern when you want to be sure that there is

**ALWAYS ONLY ONE INSTANCE OF AN OBJECT THROUGHOUT YOUR APPLICATION!!!**

What: Design Pattern: Singleton
-------------------------------

A singleton is a singleton! There is only one instance of that object in your application **per jvm**, whether or not you are running multple threads

How: Design Pattern: Singleton
------------------------------

    package nl.example.app.singleton;


    public class Singleton {

       private static Singleton instance;

       private Singleton() {}


       public static synchronized Singleton getInstance() {
          if(instance == null) {
             instance = new Singleton();
          }
          return instance;
       }


    }

    package nl.example.app.singleton;


    public class Application {

       public static void main(String[] args) {

          Singleton s = Singleton.getInstance();

          Singleton s2 = Singleton.getInstance();

          if(s != s2) {
             // should never, ever come here!
             System.out.println(0/0);
          }
          System.out.println("Successful completion");

       }

    }

Assignment: Design Pattern: Singleton
-------------------------------------

**Q:** I would say in this case, read and do it later?

**A:** === Conclusion

During this section we learned how to make use of the **Singleton** design pattern to be absolutely sure there is only one instance for an object in your appication per jvm

Topic: Design Pattern: Template
===============================

Introduction
------------

In the previous section we learned that we can use the Iteator, Adapter and Singleton design pattern.

The last pattern we will review here now is the much used (implicit or explicit) **Template** pattern which is the subject of this section

What you will learn
-------------------

-   Why and When to use the Template pattern

-   What it is

-   How to implement it

Why and When: Design Pattern: Template
--------------------------------------

When you have an abstract base class with specific behaviour and want to force that the final part of the behaviour is implemented in a specific method you can use the Template pattern

e.g. an abstract Animal base class which has al the things an animal has but the only thing that is left open is the **void makeSound()** method than you can use the Template pattern for that

What: Design Pattern: Template
------------------------------

-   abstract base class with some behaviour in and one (or more) open methods to be implemented in the …

-   concrete sub-class

How: Design Pattern: Template
-----------------------------

    package nl.example.app.template;

    import java.time.LocalDate;
    import java.time.temporal.ChronoUnit;

    public abstract class Animal {

       private String name;
       private LocalDate birthDate;

       public Animal(String name, LocalDate birthDate) {
          this.name = name;
          this.birthDate = birthDate;
       }

       public Animal() {
          this.name = "Mickey - our cat";
          this.birthDate = LocalDate.of(2011, 3, 9);
       }

       public long getAge() {
          return ChronoUnit.YEARS.between(this.birthDate,  LocalDate.now());
       }

       public abstract void makeSound();


       public String getName() {
          return name;
       }


       public void setName(String name) {
          this.name = name;
       }

    }

    package nl.example.app.template;


    public class Dog extends Animal {

       // the trick of the Template pattern is here ... to force the new collegae to not forget to implement this method and to force him/her
       @Override
       public void makeSound() {

          System.out.println("Wooof!!! ...");

       }

    }

Assignment: Design Pattern: Template
------------------------------------

**Q:** Since I expect we already know this, and spent enough time on this **Design Patterns** subject??? it is enough?

**A:** === Conclusion

During this section we learned how to make use of the **Template** pattern - and in fact you might already have used it without knowing that you were using the template pattern

That concludes this part of the course: Topic: Design Patterns

Topic: Recursion
================

Introduction
------------

Recursion is explained by trainer

What you will learn
-------------------

-   What recursion is

-   When and How to use them

-   That you do not learn it immediately

-   That you have to work with it to see and learn it

-   That it is fun!

How: Recursion
--------------

For now, best shown with code

### How: Recursion: Faculty

    package nl.example.app.recursion;

    public class Fac {

       public static int fac(int n) {

          // simplest case
          if (n == 0) {
             return 1;
          }
          else {
             return n * fac(n - 1);
          }
       }

    }

    package nl.example.app.recursion;

    import org.junit.Assert;
    import org.junit.Test;

    import nl.example.app.recursion.Fac;


    public class FacTest {

       @Test
       public void facTest() {
          Assert.assertEquals(6, Fac.fac(3));
          Assert.assertEquals(2, Fac.fac(2));
          Assert.assertEquals(120, Fac.fac(5));
       }

    }

### How: Recursion: Fibonnaci

    package nl.example.app.recursion;

    public class Fibon {

       // note: this is a bad algorithms but shows the principle of recursion pretty wel!!!
       public static int fibon(int n) {
          if (n == 0) {
             return 0;
          }
          if (n == 1) {
             return 1;
          }
          else {
             return fibon(n - 2) + fibon(n - 1);
          }
       }

    }

    package nl.example.app.recursion;

    import org.junit.Assert;
    import org.junit.Test;

    import nl.example.app.recursion.Fibon;

    public class FibonTest {

       @Test
       public void fibonTest() {
          Assert.assertEquals(5,  Fibon.fibon(5));
          Assert.assertEquals(55, Fibon.fibon(10));
          Assert.assertEquals(34+55, Fibon.fibon(11));
          Assert.assertEquals(55+89, Fibon.fibon(12));
       }

    }

### How: Recursion: Greatest common divisor | Kleinste gemene veelvoud

    package nl.example.app.recursion;

    public class GgdKgv {

       // can explain how and why but this is THE algorithm to calculate ggd
       public static int ggd(int n, int m) {
          if (n % m == 0) {
             return m;
          }
          else {
             return ggd(m, n % m);
          }
       }

       public static int kgv(int n, int m) {
          return (n * m) / ggd(n, m); // :-)
       }

    }

    package nl.example.app.recursion;

    import org.junit.Assert;
    import org.junit.Test;

    import nl.example.app.recursion.GgdKgv;


    public class GgdKgvTest {

       @Test
       public void testGgd() {
          Assert.assertEquals(6,  GgdKgv.ggd(18, 12));
          Assert.assertEquals(9,  GgdKgv.ggd(27, 18));
          Assert.assertEquals(1,  GgdKgv.ggd(27, 11));
       }

       @Test
       public void testKgv() {
          Assert.assertEquals(30,  GgdKgv.kgv(10,  30));
          Assert.assertEquals(105,  GgdKgv.kgv(5,  21));

          Assert.assertEquals(300,  GgdKgv.kgv(100,  30));
       }

    }

### How: Recursion: RecursiveList

    package nl.example.app.recursion;

    public class RecursiveList<T> {

       private T head;
       private RecursiveList<T> tail;

       public void add(T t) {
          if (this.head == null) {
             this.head = t;
             this.tail = new RecursiveList<>();
          }
          else {
             this.tail.add(t);
          }
       }

       public T get(int index) {
          if (index == 0) {
             return head;
          }
          else {
             return tail.get(--index);
          }
       }

       public boolean contains(T t) {
          if (this.head == null) {
             return false;
          }
          else {
             if (this.head.equals(t)) {
                return true;
             }
             else {
                return tail.contains(t);
             }
          }

       }

       public void update(T victim, T target) {
          if (this.head == null) {
             return;
          }
          else {
             if (this.head.equals(victim)) {
                this.head = target;
             }
             else {
                tail.update(victim, target);
             }
          }
       }

       // hardest
       public void delete(T victim) {
          if (this.head == null) {
             return;
          }
          else {
             if (this.head.equals(victim)) {
                this.head = tail.head;
                this.tail = tail.tail;
             }
             else {
                tail.delete(victim);
             }
          }
       }

       public int size() {
          if (this.head == null) {
             return 0;
          }
          else {
             return 1 + tail.size();
          }
       }

       @Override
       public String toString() {
          if (this.head == null) {
             return "";
          }
          else {
             return "" + head + tail;
          }
       }

    }

    package nl.example.app.recursion;

    import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertTrue;

    import org.junit.Before;
    import org.junit.Test;

    import nl.example.app.recursion.RecursiveList;

    public class RecursiveListTest {

       private RecursiveList<String> recList;

       @Before
       public void setUp() {
          this.recList = new RecursiveList<>();
       }


       @Test
       public void testAdd(){

          recList.add("Ray");
          recList.add("NAC");
          recList.add("Heracles");
          recList.add("Eagles");

          String result = recList.toString();
          assertEquals("RayNACHeraclesEagles", result);

          assertEquals(4, recList.size());

          assertEquals("Heracles", recList.get(2));

          assertEquals("Eagles", recList.get(3));

          assertTrue(recList.contains("NAC"));

          recList.update("NAC", "NAC is de mooiste club");

          result = recList.toString();

          assertEquals("RayNAC is de mooiste clubHeraclesEagles", result);

          recList.delete("Eagles");

          result = recList.toString();

          assertEquals("RayNAC is de mooiste clubHeracles", result);

          assertEquals(3, recList.size());
       }

    }

Assignment: Recursion
---------------------

*Target*.  
To learn to work with recursion

*Roadmap*.  
During this assignment we will plenairely implement a **Tree**

-   Tree has an Integer head

-   Tree has a left side with smaller items than head

-   Tree has a right side with larger items than head

Implement this using help of trainer

:!solution\_tree:

Topic: Spring Boot annotations
==============================

-   @Entity

    -   @Id

    -   GeneratedValue(strategy=…)

        -   strategy=GeneratedValue.IDENTITY also works with H2 database using H2 console

        -   Do we know what H2 is??

-   @Controller

    -   For Spring MVC request-driven webapps (not widely used anymore in favor of Event Driven Webapps (Angular, ReactJS, Polymer, …)

-   @RestController (for REST using Spring Rest)

    -   @RequestMethod.GET

    -   @GetMapping

    -   Both have the same meaning

-   @Component (for REST using JAX-RS)

-   @Service

    -   @Transactional

        -   Start transaction per public method if class is annotated

        -   Can also be used per (public) method

        -   Do we know this and do we know that we can use ignored **Exception** types???

-   @Repository

    -   Seen?

    -   Did we make **dynamic finders**?

    -   Did we see that Spring Boot creates a class implementation on the fly during starting?

-   @Configuration

    -   @Bean

        -   For creating beans

        -   Did we create beans yet?

Topic: Threads
==============

Introduction
------------

**Q:** In the previous sections we learned that we are pretty good in **imperative** programming. But what happens when we are not alone … what happens if there are more threads than the now only main() thread?

**A:** Working with threads and dealing with more than one thread is the subject of this section

What you will learn
-------------------

-   Why to use a thread

-   What a thread is

-   How to program a thread

Why and When: Threads
---------------------

You use threads when you have more than one process/program running. In fact you are running multiple thread on your OS (Windows/Linux/Mac) all the time. When printing and using your mouse and when compiling together you are running **multiple threads**. And … since Java is a **multithreaded** language why not also use that! :-)

What: Threads
-------------

A thread is a **lightweight** process which runs to completion!

How: Threads
------------

-   Thread();

    -   Creates a thread

-   Thread(Runnable);

    -   Creates a Thread with a Runnable instance

-   Thread.MAX\_PRIORITY, Thread.MIN\_PRIORITY, Thread.NORM\_PRIORITY

    -   To use for setting a Thread his priority e.g. primeThread.setPriority(Thread.MAX\_PRIORITY);

    -   Number from 1 (min) through 5 (normal) to 10 (max) and MAX\_PRIORITY is the highest and is the most urgent setting

-   Thread.currentThread();

    -   Returns a reference to the current thread :-)

-   void start();

    -   to start a run. The thread is started and invokes the **void run()** method

-   void run();

    -   NEVER use it directly! The start() method should be called and that will run the **run()** method

-   int getPriority();

    -   Returns the priority

-   void interrupt();

    -   Interrupts this thread

-   void join();

    -   Waits for this thread to die

Assignment: Threads
-------------------

*Target*.  
To learn working with threads

*Roadmap*.  
During this assignment you will create your first thread(s)

    package nl.example.app.threads.counterthread.assignment;

    public class Application {

       public static void main(String[] args) {

          // Create a loop here with 10 counterThreads which each print from 1 to 10 on the console
          // start hem
          // watch the output

       }
    }

    class CounterThread /* ??? */ {

       private long id;

       public CounterThread(long id) {
          this.id = id;
       }

       public void run() {

       }
    }

-   I invoke the program

-   Some threads are started

-   And print output

Conclusion
----------

During this section we learned how to make a Thread so that we can now use **muliple threading** in Java

In the following section we will learn that we can (also) make use of the **Runnable** interface

Resources
---------

-   ["Thread API", window="\_blank"](https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html)

-   ["Creating and starting Java Threads", window="\_blank"](http://tutorials.jenkov.com/java-concurrency/creating-and-starting-threads.html)

Topic: Runnable
===============

Introduction
------------

In the previous section we learned that we can create a Thread class by extending from the class **Thread**. But what if you want to turn an existing class which inherits from some parent class into a Thread? You cannot extends from more than one class in Java. How to fix this issue is the subject of this section

What you will learn
-------------------

-   Why you use the interface **Runnable**

-   Why you use the interface **Runnable**

-   How to use the interface **Runnable**

Why and When: Runnable
----------------------

You use interface Runnable when you want to turn an existing class into a Runnable to be used by a Thread

What: Runnable
--------------

    public interface Runnable {
            void run();
    }

How: Runnable
-------------

    package nl.example.app.thread.runnable;

    public class Application {

       public static void main(String[] args) {
          // Start B as thread :-)
          new Thread(new B()).start();
       }

    }

    class A {

    }

    class B extends A implements Runnable {

       public void run() {
          for (int i = 0; i < 3; i++) {
             System.out.println(i);
          }
       }

    }

Assignment: Runnable
--------------------

*Target*.  
To use the interface Runnable

*Roadmap*.  
During this assignment you will create a Person class and a subclass Postman which you will turn into a Runnable

-   The code above

-   Create a class Person

-   Create a subclass of Person with name Postman

-   Turn the (sub) class Postman into a Runnable

-   Create a thread which starts the Postman

Conclusion
----------

During this section we learned how to make use of the interface Runnable to avoid problems with inheritance and threading

In the following section we will learn that we world is not so easy at it seems in the world of **Concurrent Programming** and we will dive in the topic **Synchronization**

Topic: Synchronization
======================

Introduction
------------

In the previous section we learned that thread can run on our machine. These threads were pretty kind. They ran without bumping into each other or bumping into each others shared resources.

The world is different than that, e.g. a toiletvisit will become very strange is everyone can visit that toilet when he wants to. So there must be some kind of locking and synchronization.

**Locking** and **Synchronization** will be the subject of this section

What you will learn
-------------------

-   Why synchronization must take place

-   What synchronization is

-   How to synchronize your code

Why and When: Synchronization
-----------------------------

Synchronization forms the basis of the execution of multiple threads asynchronously in a multithreaded application. It provides the means to achieve the sharing of resources such as file handling, network connections and memory by coordinating threads and processes to avoid data corruption.

What: Synchronization
---------------------

Synchronization, in the context of Java, is a process that involves coordinating the execution of multiple threads to ensure a desired outcome without corrupting the shared data and preventing any occurrence of deadlocks and race conditions.

How: Synchronization
--------------------

In java, Synchronization, for starters, is done using the **synchronized** keyword

    public synchronized void onlyOne() {

    }

    Integer age = 0;

    public void onlyOneForBlock() {


            synchronized(this.age) {
                    age++;
            }

    }

Assignment: Synchronization
---------------------------

*Target*.  
To learn working with synchronization

*Roadmap*.  
During this assignment you will create / finish as assignment regarding a bakery and some clients

-   The following skeleton / template code

-   I run the application

-   Finally all breads should be consumed and no-one should remain

> **Tip**
>
> Watch the // Add your code here! tips in the code

    package nl.example.app.thread.synchronisation.assignment;


    public class Application {

       public static void main(String[] args) throws InterruptedException {

          Bakker b = new Bakker();

          Klant k1 = new Klant();
          Klant k2 = new Klant();
          Klant k3 = new Klant();

          b.start();

          k1.start();
          k2.start();
          k3.start();

          Thread.sleep(5000);

          System.out.println(Voorraad.getInstance().getVoorraad());

       }

    }

    package nl.example.app.thread.synchronisation.assignment;


    // This bakker will bake 30 breads in one run method which increments the voorraad
    public class Bakker extends Thread {

       private Voorraad voorraad = Voorraad.getInstance();


       public void bak() {
          voorraad.increment();
       }

       @Override
       public void run() {

          // Add your code here!
       }

    }

    package nl.example.app.thread.synchronisation.assignment;

    // this klant will buy 10 breads (so start 3 Klants which decrement the voorraad)
    public class Klant extends Thread {

       private Voorraad voorraad = Voorraad.getInstance();

       @Override
       public void run() {
          // Add your code here!
       }
    }

    package nl.example.app.thread.synchronisation.assignment;

    // This class models the voorraad (supply)
    public class Voorraad {

       private static Voorraad instance;

       public static synchronized Voorraad getInstance() {

          if (instance == null) {
             instance = new Voorraad();
          }

          return instance;

       }

       private int voorraad;

       private Voorraad() {

       }

       public synchronized void increment() {
          // Add your code here!
       }

       public synchronized void decrement() throws InterruptedException {
         // Add your code here!
       }

       public int getVoorraad() {
          return voorraad;
       }

    }

:!solution\_synchronization:

Conclusion
----------

During this section we learned how to make use of the different problems we might run into using **Concurrent Programming**

> **Tip**
>
> There is a lot more on concurrent programming, especially since Java 7. We will reskate over that part during the upcoming training. For now we have met the threading and concurrency and we have to let that cement dry for this days / week(s).

Topic: Regular Expressions
==========================

Introduction
------------

During this part we will **introduce** the **principle** of **Regular Expressions** as a whole, not for a language hence language agnostic or even polyglot, which means for some other languages to see that Java has some lack of handyness in Regular Expressions

What: Regular Expressions
-------------------------

Regular Expressions are a way to express an **alfabet** using **variables**

Stated less mathematically, it is a way to express a language or a pattern where some string should comply to

More Simpler, it is a language where I for example, can tell using an **expression** that a Dutch zipcode (Dutch: postcode) should comply to the following pattern

-   starts with a four digit number between 1000 and 9999

-   next might follow a space (a single space only)

-   then there come two capital letters

The way to go to express such a term might be done using **Regular Expressions**

### What: Demo Rubular.com

Show ["Rubular.com a great RegExp creation and tesing website", window="\_blank"](https://rubular.com/)

Why: Regular Expressions
------------------------

To have a handy way to validate a string to a pattern

When: Regular Expressions
-------------------------

When someone types in a zipcode in a HTML screen, there should follow some validation that the zipcode is correct. Using the Regular Expressions is a very handy tool for that

How: Regular Expressions
------------------------

### Creating a regular expression and matching

    package nl.smulweb.foodcorner.regexp;

    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Application {

       public static void main(String[] args) {

          // 1st way
          Pattern p = Pattern.compile("[1-9]{1}[0-9]{3}\\s?[A-Z]{2}"); // that crappy \\ :-(
          // p is here a kind of regexp
          Matcher matcher = p.matcher("1013AB");

          boolean matches = matcher.matches();
          if (matches) {
             System.out.println("Matches");
          }

          // 2nd way
          boolean b2 = Pattern.compile(".s").matcher("as").matches();

          // 3rd way
          boolean b3 = Pattern.matches(".s", "as");
       }

    }

    package nl.smulweb.foodcorner.regexp.parsing;

    import java.util.regex.MatchResult;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Application {

       public static void main(String[] args) {

          // example one
          {
             Pattern p = Pattern.compile("([A-Z]+[1-9]{1,2}\\s?)+?");
             Matcher matcher = p.matcher("A13 B14 ");

             if (matcher.matches()) {
                System.out.println("yes");
                String allMatch = matcher.group(0);
                System.out.println(allMatch);

                System.out.println("How many groups:" + matcher.groupCount()); // 0 is one big group

                System.out.println("all group: " + matcher.group(0));

                System.out.println(matcher.group(1));
             }
          }

          // example two
          {
             Pattern p = Pattern.compile("([A-Z]+[1-9]{1,2}\\s?)+?");
             Matcher matcher = p.matcher("A13 B14");

             while (matcher.find()) {
                System.out.println("I found the text " + matcher.group() + " starting at index " +
                                  matcher.start() + " and ending at index " + matcher.end());
             }

          }

          // example 3
          {
             Pattern p = Pattern.compile("[a-z]+@[a-z]+\\.[a-z]{2,3}");
             Matcher matcher = p.matcher("raymond@carpago.nl");
             if (matcher.matches()) {
                MatchResult matchResult = matcher.toMatchResult();
                int groupCount = matchResult.groupCount();
                for (int i = 0; i <= groupCount; i++) {
                   System.out.println("MatchResult:>" + matchResult.group(i) + "<");
                }
             }

          }

       }

    }

### Common patterns

-   \\d Any digit character

-   \\w An alphanumeric character (“word character”)

-   \\s Any whitespace character (space, tab, newline, and similar)

-   \\D A character that is not a digit

-   \\W A nonalphanumeric character

-   \\S A nonwhitespace character

-   .(period) Any character except for newline

-   \^ Begin matching at the start of the input string

-   \$ End matching at the end of the input string

<!-- -->

    Pattern p = Pattern.compile("[a-zA-Z]{3}");

    Pattern twoDigitsInvalid = Pattern.compile("\d{2}"); // compile error
    Pattern twoDigitsValid = Pattern.compile("\\d{2}"); // OK, see the double backslash here

> **Warning**
>
> In Java it is still only possible to create a **Regular Expression** by using a String. Hence, in a String a backslash indicates a **special sign follows**, the literal \\ to state that we have a *\\s* should be preceeded with a *\\*, hence the double backslash.

In languages like JavaScript, Perl and Ruby a syntax like this is correct

    let re = /\s+\b{3}/;
    let re1 = //; // <= put the regex in between the two slashes. No string needed.

API
---

-   static Pattern compile()

-   Matcher matcher(String)

-   boolean matches()

-   boolean matches()

-   boolean find()

-   String group()

-   int groupCount()

-   Pattern pattern()

-   Matcher reset()

-   Matcher reset(String newInput)

-   int start()

-   int end()

-   MatchResult toMatchResult()

-   int groupCount

Assignment I: Creating and testing a Regexp pattern
---------------------------------------------------

### Create and Test with a RegExp pattern

-   Learn how to create and test a regexp expression pattern

-   During this assignment you will create and test a regexp expression pattern for the Dutch zipCode pattern

-   Create an Application class with a main method

    -   create a Regexp expression which validates the Dutch zipCode pattern

    -   test it

-   Do the same for the emailaddress which are valid (perhaps except the .co.uk domain)

-   matching the A-class of the IP-adress range

-   Do the same for the ["semantic versioning", window="\_blank"](http://semver.org) numbers

-   The next step after creating this RegExp is to use it for some use case like test (or match). In the next assignment we will use it for **testing**

Assignment II: Using the RegExp find method
-------------------------------------------

-   To learn to work with the **find** method on the Matcher class

-   During this assignment you will parse your birthdate out of a string with a RegExp

<!-- -->

    package nl.smulweb.foodcorner.regexp.parsing.assignment;

    import java.time.LocalDate;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    public class Application {

       public static void main(String[] args) {

          System.out.println("Example 1");
          {
             String label = "I was born on 09-08-1968 and that was a Friday!!!";
             Pattern p = Pattern.compile("// ??? ///");
             Matcher matcher = p.matcher(label);

             while (matcher.find()) {
                System.out.println(">" + matcher.group() + "<");
             }
          }

          System.out.println("Example 2");
          {
             String label = "I was born on 09-08-1968 and that was a Friday!!!";
             Pattern p = Pattern.compile("/// ??? ///");
             Matcher matcher = p.matcher(label);

             if (matcher.matches()) {
                String all = null; //??? matcher.(???)
                String day = null; // idem
                String month = null;
                String year = null;

                LocalDate birthDate = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));

                System.out.println(birthDate.getDayOfWeek());
             }
             else {
                System.out.println("No match");
             }

          }
       }
    }

:!solution\_re\_exec:

Follow-up: RegExp
-----------------

Below you find for this topic some extra resources to watch after the week the topic is introduced during the training

-   ["Rubylar.com", window="\_blank"](https://rubular.com/)

-   ["Java RegExp explained", window="\_blank"](https://www.javatpoint.com/java-regex)

Topic: Copy On Write ArrayList
==============================

Introduction
------------

Following the slide and pdf we now learned some regarding collections.

The part of collections are pretty straightforward and trivial.

The perhaps harder part of this is something regarding the pretty new class **CopyOnWriteArrayList** which is the subject of this section

What: Copy On Write ArrayList
-----------------------------

The design of the CopyOnWriteArrayList uses an interesting technique to make it thread-safe without a need for synchronization. When we are using any of the modify methods – such as add() or remove() – the whole content of the CopyOnWriteArrayList is copied into the new internal copy.

Due to this simple fact, we can iterate over the list in a safe way, even when concurrent modification is happening.

When we’re calling the iterator() method on the CopyOnWriteArrayList, we get back an Iterator backed up by the immutable snapshot of the content of the CopyOnWriteArrayList.

Its content is an exact copy of data that is inside an ArrayList from the time when the Iterator was created. Even if in the meantime some other thread adds or removes an element from the list, that modification is making a fresh copy of the data that will be used in any further data lookup from that list.

The characteristics of this data structure make it particularly useful in cases when we are iterating over it more often than we are modifying it. If adding elements is a common operation in our scenario, then CopyOnWriteArrayList won’t be a good choice – because the additional copies will definitely lead to sub-par performance.

How: Copy On Write ArrayList
----------------------------

    package nl.example.app.concurrency.copy.on.write.arraylist;

    import java.util.*;
    import java.util.concurrent.CopyOnWriteArrayList;

    public class Application {

        public static void main(String[] args) {
            // problem but rocks. Do you see why?
            {

                List<Integer> numbers = new ArrayList<>();
                numbers.addAll(Arrays.asList(1, 1, 2, 5, 3, 4, 5, 5, 6));

                int size = numbers.size();

                // rocks since the size is queried per iteration
                for (int index = 0; index < size; index++) {
                    if (5 == numbers.get(index)) {
                        numbers.remove(index--);
                        System.out.println(numbers);
                    }
                }
                System.out.println(numbers);
            }

            // fails
            {
                List<Integer> numbers = new ArrayList<>();
                numbers.addAll(Arrays.asList(1, 1, 2, 3, 5, 8, 13));

                boolean hit = false;

                try {
                    for (int element : numbers) {

                        if (element == 5) {
                            numbers.remove(new Integer(5));
                        }
                    }
                } catch (ConcurrentModificationException cme) {
                    // should come here!!!
                    hit = true;
                }

                assert hit;
            }

            // rocks!
            {
                List<Integer> numbers = new CopyOnWriteArrayList<>();
                numbers.addAll(Arrays.asList(1, 1, 2, 3, 5, 8, 13));


                boolean hit = false;

                try {
                    for (int element : numbers) {

                        if (element == 5) {
                            numbers.remove(new Integer(5));
                        }
                    }
                } catch (ConcurrentModificationException cme) {
                    // should NOT come here!!!
                    hit = true;
                }

                assert !hit;

            }


        }

    }

Credits: ["Guide to Copy on Write ArrayList (Baeldung)", window="\_blank"](https://www.baeldung.com/java-copy-on-write-arraylist)

Assignment: Copy On Write ArrayList
-----------------------------------

*Target*.  
To learn working with the copy on write arraylist

*Roadmap*.  
During this assignment you will remove every odd number of an ArrayList

    package nl.example.app.concurrency.copy.on.write.arraylist.assignment;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.concurrent.CopyOnWriteArrayList;

    public class Application {

        public static void main(String[] args) {


            List<Integer> numbers = new ArrayList<>();
            numbers.addAll(Arrays.asList(0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89));

            System.out.println(numbers);

            for (int element : numbers) {
                if (element % 2 == 0) {
                    numbers.remove(new Integer(element));
                }
            }

            System.out.println(numbers);


        }
    }

-   I run the program

-   Then the **ConcurrentModificationException** should not be shown anymore

    **Q:** TIP: Be aware of the **remove** method. It removes by index. How would you remove an Object with the value **5** from the list?

    **A:** (think of Wrapper classes)

General Resources
=================

-   ["Some interesting and learning Java Exercises", window="\_blank"](https://www.w3resource.com/java-exercises/)


