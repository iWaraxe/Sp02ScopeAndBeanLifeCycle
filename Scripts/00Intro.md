# Lecture 2: Spring Bean Scopes and Lifecycle

### Lecture Duration: 60 minutes

---

## Lecture Outline:

1. **Bean Scopes**
    2. Singleton
    3. Prototype
    4. Request
    5. Session
    6. Global Session

2. **Bean Lifecycle**
    2. Initialization and destruction callbacks
    3. Lifecycle annotations: `@PostConstruct` and `@PreDestroy`

3. **Dependency Injection**
    2. Constructor-based DI
    3. Setter-based DI
    4. Injecting collections (List, Set, Map)
    5. Injection of Strings and other values
    6. Injection from properties file

4. **Annotations**
    2. `@Autowired` for constructor, setter, and field
    3. `@Qualifier`
    4. `@Value`
    5. `@Scope`
    6. `@PropertySource`

---

## 1. Bean Scopes (10 minutes)

### 1.1. Introduction to Bean Scopes
- **Singleton Scope:** Default scope; a single instance per Spring IoC container.
- **Prototype Scope:** New instance every time a bean is requested.
- **Request Scope:** New instance per HTTP request.
- **Session Scope:** New instance per HTTP session.
- **Global Session Scope:** Used in portlet-based applications.

### 1.2. Examples
```java
@Bean
@Scope("singleton")
public MyClass singletonBean() {
    return new MyClass();
}

@Bean
@Scope("prototype")
public MyClass prototypeBean() {
    return new MyClass();
}

@Bean
@Scope("request")
public MyClass requestBean() {
    return new MyClass();
}

@Bean
@Scope("session")
public MyClass sessionBean() {
    return new MyClass();
}

@Bean
@Scope("globalSession")
public MyClass globalSessionBean() {
    return new MyClass();
}
```

## 2. Bean Lifecycle (15 minutes)

### 2.1. Initialization and Destruction Callbacks
- Custom initialization and destruction methods.
- Lifecycle annotations: `@PostConstruct` and `@PreDestroy`.

### 2.2. Examples
```java
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class MyClass {

    @PostConstruct
    public void init() {
        System.out.println("Bean is going through init.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Bean will destroy now.");
    }
}
```

## 3. Dependency Injection (20 minutes)

### 3.1. Constructor-based DI
- Advantages: immutability, dependency requirements enforced.

### 3.2. Setter-based DI
- Advantages: flexibility, optional dependencies.

### 3.3. Injecting Collections
```java
@Bean
public List<String> myList() {
    return Arrays.asList("Value1", "Value2", "Value3");
}

@Bean
public Set<String> mySet() {
    return new HashSet<>(Arrays.asList("Value1", "Value2", "Value3"));
}

@Bean
public Map<String, String> myMap() {
    return Map.of("key1", "value1", "key2", "value2");
}
```

### 3.4. Injection of Strings and Other Values
```java
@Bean
public String myString() {
    return "Hello, World!";
}
```

### 3.5. Injection from Properties File
```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class MyComponent {

    @Value("${my.property}")
    private String myProperty;

    public String getMyProperty() {
        return myProperty;
    }
}
```

## 4. Annotations (10 minutes)

### 4.1. `@Autowired` for Constructor, Setter, and Field
- **Constructor Injection**
```java
@Component
public class MyService {
    private final MyRepository repository;

    @Autowired
    public MyService(MyRepository repository) {
        this.repository = repository;
    }
}
```

- **Setter Injection**
```java
@Component
public class MyService {
    private MyRepository repository;

    @Autowired
    public void setRepository(MyRepository repository) {
        this.repository = repository;
    }
}
```

- **Field Injection**
```java
@Component
public class MyService {
    @Autowired
    private MyRepository repository;
}
```

### 4.2. `@Qualifier`
```java
@Autowired
@Qualifier("specificBean")
private MyClass myBean;
```

### 4.3. `@Value`
```java
@Value("${property.name}")
private String propertyName;
```

### 4.4. `@Scope`
- As discussed in bean scopes.

### 4.5. `@PropertySource`
- As discussed in properties injection.

## 5. Q&A and Homework Assignment (5 minutes)

### Homework Tasks:
1. Create a Spring application demonstrating different bean scopes.
2. Implement lifecycle methods using `@PostConstruct` and `@PreDestroy`.
3. Create beans using constructor-based and setter-based DI.
4. Inject collections (List, Set, Map) into beans.
5. Use `@Value` to inject properties from a properties file.