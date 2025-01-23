**Team 4: Search and Browse**

**Responsibilities:**

- Implement functionalities for users to search and browse books.
- Allow searching by title, author, or category.
- Use Streams API for efficient search and filtering.

**Concepts to Cover:**

- OOP (Classes, Objects, Inheritance)
- Collections (ArrayList for storing book information)
- Streams API (Filtering, mapping, and reducing book collections)
- Unit Testing (JUnit for testing search and browse functionalities)

1. **Strategy Pattern**
2. **Factory Method Pattern**

**Strategy Pattern**

**Definition:** The Strategy Pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern lets the algorithm vary independently from clients that use it.

**Usage in the Code:**

- The SearchStrategy interface defines a common interface for all search strategies.
- Concrete strategies (SearchByAuthor, SearchByTitle, SearchByCategory) implement the SearchStrategy interface.
- The SearchService class uses a SearchStrategy to perform searches. The strategy can be set at runtime using the [setSearchStrategy](vscode-file://vscode-app/c:/Program%20Files/Microsoft%20VS%20Code/resources/app/out/vs/code/electron-sandbox/workbench/workbench.html"%20\o%20") method.

**Benefits:**

- **Flexibility:** You can change the search strategy at runtime.
- **Encapsulation:** Each search strategy is encapsulated in its own class.
- **Maintainability:** Adding new search strategies does not affect existing code.

**Example :**

![image](https://github.com/user-attachments/assets/498b8a3e-2c73-4dfd-973f-5e0f234d5715)


**Factory Method Pattern**

**Definition:** The Factory Method Pattern defines an interface for creating an object, but lets subclasses alter the type of objects that will be created.

**Usage in the Code:**

- The Book class uses a parameterized constructor to create instances of Book.
- Although not explicitly shown as a factory method, the creation of Book objects in the App class can be seen as a simple form of factory method usage.

**Benefits:**

- **Encapsulation:** The creation logic is encapsulated in the factory method.
- **Reusability:** The same factory method can be used to create different types of objects.
- **Maintainability:** Changes to the creation logic are centralized in the factory method.

**Example :**

![image](https://github.com/user-attachments/assets/5bf18c9a-cdb7-4dcc-9067-ccaea6b0345c)



**Uml Diagram:**

![image](https://github.com/user-attachments/assets/47e96636-da26-45d2-82e1-9148ba1fb19b)


