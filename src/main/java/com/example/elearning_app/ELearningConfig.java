package com.example.elearning_app;

import com.example.elearning_app.models.course.Course;
import com.example.elearning_app.models.course.CourseRepository;
import com.example.elearning_app.models.lesson.Lesson;
import com.example.elearning_app.models.quiz.Quiz;
import com.example.elearning_app.models.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class ELearningConfig {

    private final CourseRepository courseRepository;
    private final UserRepository repository;

    public static List<Quiz> getHtmlQuizzes() {
        List<Quiz> htmlQuizzes = new ArrayList<>();

        // HTML MCQ 1
        Quiz htmlQuiz1 = new Quiz(
                "What does HTML stand for?",
                "A. Hyper Text Markup Language\nB. High Transferability and Markup Language\nC. Hyperlink and Text Markup Language\nD. Home Tool Markup Language",
                1);
        htmlQuizzes.add(htmlQuiz1);

        // HTML MCQ 2
        Quiz htmlQuiz2 = new Quiz(
                "Which HTML tag is used for creating an ordered list?",
                "A. &lt;ul&gt;\nB. &lt;li&gt;\nC. &lt;ol&gt;\nD. &lt;dl&gt;",
                3);
        htmlQuizzes.add(htmlQuiz2);

        // HTML MCQ 3
        Quiz htmlQuiz3 = new Quiz(
                "What is the correct HTML tag for inserting a line break?",
                "A. &lt;br&gt;\nB. &lt;lb&gt;\nC. &lt;break&gt;\nD. &lt;newline&gt;",
                1);
        htmlQuizzes.add(htmlQuiz3);

        // HTML MCQ 4
        Quiz htmlQuiz4 = new Quiz(
                "Which attribute is used to provide additional information about an element?",
                "A. class\nB. id\nC. style\nD. title",
                4);
        htmlQuizzes.add(htmlQuiz4);

        // HTML MCQ 5
        Quiz htmlQuiz5 = new Quiz(
                "In HTML, which tag is used to create a hyperlink?",
                "A. &lt;a&gt;\nB. &lt;link&gt;\nC. &lt;href&gt;\nD. &lt;url&gt;",
                1);
        htmlQuizzes.add(htmlQuiz5);

        return htmlQuizzes;
    }

    @Bean
    CommandLineRunner commandLineRunner() {

        return args -> {

            var courses = List.of(
                    new Course
                            (
                                    "HTML",
                                    "html.png",
                                    "No prior coding experience? No problem! This beginner-friendly course will guide you through the fundamentals of HTML, the language that builds the websites you use every day.",
                                    new LinkedHashSet<>(
                                            List.of(
                                                    new Lesson("Introduction to HTML", "HTML (HyperText Markup Language) is the standard markup language for creating web pages. An HTML document consists of various elements that structure the content. Here's a basic structure:\n" +
                                                            "\n" +
                                                            "<!DOCTYPE html>: Document type declaration.\n" +
                                                            "<html>: Root element.\n" +
                                                            "<head>: Contains meta-information about the document.\n" +
                                                            "<title>: Sets the title of the document.\n" +
                                                            "<body>: Contains the content of the document.\n" +
                                                            "An example HTML document:\n\n" +
                                                            "<!DOCTYPE html>\n" +
                                                            "<html lang=\"en\">\n" +
                                                            "<head>\n" +
                                                            "    <meta charset=\"UTF-8\">\n" +
                                                            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                                                            "    <title>My First HTML Page</title>\n" +
                                                            "</head>\n" +
                                                            "<body>\n" +
                                                            "    <h1>Hello, World!</h1>\n" +
                                                            "    <p>This is a simple HTML page.</p>\n" +
                                                            "</body>\n" +
                                                            "</html>"), new Lesson("HTML Forms", "HTML forms are used to collect user input. They are created using the <form> element. A basic form includes elements like <input>, <textarea>, <select>, and <button>.HTML forms are used to collect user input. They are created using the <form> element. A basic form includes elements like <input>, <textarea>, <select>, and <button>.\nExample Form:\n" +
                                                            "\n" +

                                                            "<form action=\"/submit\" method=\"post\">\n" +
                                                            "    <label for=\"username\">Username:</label>\n" +
                                                            "    <input type=\"text\" id=\"username\" name=\"username\" required>\n" +
                                                            "\n" +
                                                            "    <label for=\"password\">Password:</label>\n" +
                                                            "    <input type=\"password\" id=\"password\" name=\"password\" required>\n" +
                                                            "\n" +
                                                            "    <label for=\"gender\">Gender:</label>\n" +
                                                            "    <select id=\"gender\" name=\"gender\">\n" +
                                                            "        <option value=\"male\">Male</option>\n" +
                                                            "        <option value=\"female\">Female</option>\n" +
                                                            "    </select>\n" +
                                                            "\n" +
                                                            "    <label for=\"comments\">Comments:</label>\n" +
                                                            "    <textarea id=\"comments\" name=\"comments\" rows=\"4\" cols=\"50\"></textarea>\n" +
                                                            "\n" +
                                                            "    <button type=\"submit\">Submit</button>\n" +
                                                            "</form>")
                                            )), new HashSet<>(getHtmlQuizzes())
                            ),

                    new Course
                            (
                                    "CSS",
                                    "css.png",
                                    "This course is designed to provide a comprehensive introduction to Cascading Style Sheets (CSS) for web development. Participants will learn the fundamentals of styling HTML documents to create visually appealing and responsive web pages.", new LinkedHashSet<>(
                                    List.of(
                                            new Lesson("Introduction to CSS", "\n" +
                                                    "Certainly! Here are two lessons in regular text format for CSS.\n" +
                                                    "\n" +
                                                    "Lesson 1: Introduction to CSS\n" +
                                                    "\n" +
                                                    "Objective: Understand the basics of CSS (Cascading Style Sheets) and apply styles to HTML elements.\n" +
                                                    "\n" +
                                                    "Content:\n" +
                                                    "\n" +
                                                    "CSS is a styling language that is used to control the presentation of HTML documents. It allows you to define styles for elements, such as colors, fonts, spacing, and layout. Here are some key concepts:\n" +
                                                    "\n" +
                                                    "Selectors: CSS uses selectors to target HTML elements. For example, to select all paragraphs, you can use p.\n" +
                                                    "\n" +
                                                    "Properties and Values: Styles are defined using property-value pairs. For instance, to set the color of text, you can use color: red;.\n" +
                                                    "\n" +
                                                    "Style Rule: A style rule consists of a selector and a declaration block. For example:\n" +
                                                    "\n" +
                                                    "p {\n" +
                                                    "    color: blue;\n" +
                                                    "    font-size: 16px;\n" +
                                                    "}\n" +
                                                    "External CSS: Styles can be placed in an external CSS file and linked to an HTML document using the <link> element.\n" +
                                                    "\n" +
                                                    "Example CSS:\n" +
                                                    "\n" +
                                                    "body {\n" +
                                                    "    font-family: Arial, sans-serif;\n" +
                                                    "    background-color: #f4f4f4;\n" +
                                                    "}\n" +
                                                    "\n" +
                                                    "h1 {\n" +
                                                    "    color: #333;\n" +
                                                    "}\n" +
                                                    "\n" +
                                                    ".container {\n" +
                                                    "    width: 80%;\n" +
                                                    "    margin: 0 auto;\n" +
                                                    "}"), new Lesson("CSS Flexbox", "CSS Flexbox (Flexible Box Layout) is a layout model that provides an efficient way to design complex layouts. Key concepts include:\n" +
                                                    "\n" +
                                                    "Container and Items: Flexbox involves a flex container and its flex items. Apply display: flex; to the container.\n" +
                                                    "\n" +
                                                    "Flex Direction: The direction of the main axis can be set using flex-direction. Options include row, column, row-reverse, and column-reverse.\n" +
                                                    "\n" +
                                                    "Justify Content: Aligns items on the main axis. Options include flex-start, flex-end, center, space-between, and space-around.\n" +
                                                    "\n" +
                                                    "Align Items: Aligns items on the cross axis. Options include flex-start, flex-end, center, baseline, and stretch.\n" +
                                                    "\n" +
                                                    "Example Flexbox CSS:\n" +
                                                    "\n" +

                                                    "/* Flex container styles */\n" +
                                                    ".flex-container {\n" +
                                                    "    display: flex;\n" +
                                                    "    justify-content: space-between;\n" +
                                                    "    align-items: center;\n" +
                                                    "}\n" +
                                                    "\n" +
                                                    "/* Flex item styles */\n" +
                                                    ".flex-item {\n" +
                                                    "    flex: 1;\n" +
                                                    "    margin: 10px;\n" +
                                                    "}")
                                    )), new HashSet<>(getHtmlQuizzes())
                            ),

                    new Course(
                            "C Programming",
                            "cs.png",
                            "Ever built a castle out of Legos? C# is like the building blocks of software, and this course will be your blueprint for constructing incredible digital creations.", new LinkedHashSet<>(
                            List.of(
                                    new Lesson("Introduction to C Programming", "C is a general-purpose programming language known for its efficiency and close-to-the-hardware capabilities. Here are some key concepts:\n" +
                                            "\n" +
                                            "Hello, World!: The traditional first program in any programming language is \"Hello, World!\" In C, it looks like this:\n" +
                                            "\n" +

                                            "#include <stdio.h>\n" +
                                            "\n" +
                                            "int main() {\n" +
                                            "    printf(\"Hello, World!\\n\");\n" +
                                            "    return 0;\n" +
                                            "}\n" +
                                            "Structure of a C Program:\n" +
                                            "\n" +
                                            "#include <stdio.h>: Includes the standard input/output library.\n" +
                                            "int main() { ... }: The main function where program execution begins.\n" +
                                            "printf(): A function to print output.\n" +
                                            "Compile and Run: To compile the program, use a C compiler (e.g., GCC). Save the code in a file (e.g., hello.c) and run the following commands:\n" +
                                            "\n" +
                                            "gcc hello.c -o hello\n" +
                                            "./hello"), new Lesson("C Functions and Parameters", "Functions in C allow you to break down a program into smaller, manageable pieces. Here are some key concepts:\n" +
                                            "\n" +
                                            "Function Declaration and Definition:\n" +
                                            "\n" +
                                            "Declaration: return_type function_name(parameters);\n" +
                                            "Definition:\n" +
                                            "return_type function_name(parameters) {\n" +
                                            "    // Function body\n" +
                                            "}\n" +
                                            "Parameters and Arguments:\n" +
                                            "\n" +
                                            "Functions can take parameters, which act as variables inside the function.\n" +
                                            "Example:\n" +
                                            "#include <stdio.h>\n" +
                                            "\n" +
                                            "// Function declaration\n" +
                                            "void greetUser(char name[]);\n" +
                                            "\n" +
                                            "int main() {\n" +
                                            "    // Function call with argument\n" +
                                            "    greetUser(\"John\");\n" +
                                            "    return 0;\n" +
                                            "}\n" +
                                            "\n" +
                                            "// Function definition\n" +
                                            "void greetUser(char name[]) {\n" +
                                            "    printf(\"Hello, %s!\\n\", name);\n" +
                                            "}\n" +
                                            "Return Statement: Functions can return a value using the return statement.\n" +
                                            "\n" +
                                            "Function Prototypes: It's common to declare functions at the beginning of the program to inform the compiler about their existence.\n" +
                                            "\n" +
                                            "Example C Code:\n" +
                                            "\n" +
                                            "#include <stdio.h>\n" +
                                            "\n" +
                                            "// Function prototype\n" +
                                            "int addNumbers(int a, int b);\n" +
                                            "\n" +
                                            "int main() {\n" +
                                            "    int result = addNumbers(5, 7);\n" +
                                            "    printf(\"Sum: %d\\n\", result);\n" +
                                            "    return 0;\n" +
                                            "}\n" +
                                            "\n" +
                                            "// Function definition\n" +
                                            "int addNumbers(int a, int b) {\n" +
                                            "    return a + b;\n" +
                                            "}")
                            )), new HashSet<>(getHtmlQuizzes())
                    ),
                    new Course
                            (
                                    "Java Programming",
                                    "java.png",
                                    "Through this course we'll navigate the hidden temples of data structures and algorithms, unleashing the beast of object-oriented programming within you.",
                                    new LinkedHashSet<>(
                                            List.of(
                                                    new Lesson("Introduction to Java Programming", "Java is a versatile, object-oriented programming language known for its platform independence. Here are some key concepts:\n" +
                                                            "\n" +
                                                            "Hello, World!: The traditional first program in any programming language is \"Hello, World!\" In Java, it looks like this:\n" +
                                                            "\n" +
                                                            "public class HelloWorld {\n" +
                                                            "    public static void main(String[] args) {\n" +
                                                            "        System.out.println(\"Hello, World!\");\n" +
                                                            "    }\n" +
                                                            "}\n" +
                                                            "Structure of a Java Program:\n" +
                                                            "\n" +
                                                            "public class HelloWorld { ... }: Defines a class named HelloWorld.\n" +
                                                            "public static void main(String[] args) { ... }: The main method where program execution begins.\n" +
                                                            "System.out.println(): A method to print output.\n" +
                                                            "Compile and Run: Save the code in a file (e.g., HelloWorld.java) and run the following commands:\n" +
                                                            "\n" +
                                                            "javac HelloWorld.java\n" +
                                                            "java HelloWorld"), new Lesson("Java Functions and Parameters", "Methods in Java allow you to organize code into reusable blocks. Here are some key concepts:\n" +
                                                            "\n" +
                                                            "Method Declaration and Definition:\n" +
                                                            "\n" +
                                                            "Declaration: returnType methodName(parameters) { ... }\n" +
                                                            "Definition:\n" +

                                                            "returnType methodName(parameters) {\n" +
                                                            "    // Method body\n" +
                                                            "}\n" +
                                                            "Parameters and Arguments:\n" +
                                                            "\n" +
                                                            "Methods can take parameters, which act as variables inside the method.\n" +
                                                            "Example:\n" +
                                                            "public class Greeting {\n" +
                                                            "    // Method declaration\n" +
                                                            "    public static void greetUser(String name) {\n" +
                                                            "        System.out.println(\"Hello, \" + name + \"!\");\n" +
                                                            "    }\n" +
                                                            "\n" +
                                                            "    // Main method\n" +
                                                            "    public static void main(String[] args) {\n" +
                                                            "        // Method call with argument\n" +
                                                            "        greetUser(\"John\");\n" +
                                                            "    }\n" +
                                                            "}\n" +
                                                            "Return Statement: Methods can return a value using the return statement.\n" +
                                                            "\n" +
                                                            "Example Java Code:\n" +
                                                            "\n" +

                                                            "public class Calculator {\n" +
                                                            "    // Method declaration\n" +
                                                            "    public static int addNumbers(int a, int b) {\n" +
                                                            "        return a + b;\n" +
                                                            "    }\n" +
                                                            "\n" +
                                                            "    // Main method\n" +
                                                            "    public static void main(String[] args) {\n" +
                                                            "        // Method call with arguments\n" +
                                                            "        int result = addNumbers(5, 7);\n" +
                                                            "        System.out.println(\"Sum: \" + result);\n" +
                                                            "    }\n" +
                                                            "}Methods in Java allow you to organize code into reusable blocks. Here are some key concepts:\n" +
                                                            "\n" +
                                                            "Method Declaration and Definition:\n" +
                                                            "\n" +
                                                            "Declaration: returnType methodName(parameters) { ... }\n" +
                                                            "Definition:\n" +
                                                            "returnType methodName(parameters) {\n" +
                                                            "    // Method body\n" +
                                                            "}\n" +
                                                            "Parameters and Arguments:\n" +
                                                            "\n" +
                                                            "Methods can take parameters, which act as variables inside the method.\n" +
                                                            "Example:\n" +
                                                            "public class Greeting {\n" +
                                                            "    // Method declaration\n" +
                                                            "    public static void greetUser(String name) {\n" +
                                                            "        System.out.println(\"Hello, \" + name + \"!\");\n" +
                                                            "    }\n" +
                                                            "\n" +
                                                            "    // Main method\n" +
                                                            "    public static void main(String[] args) {\n" +
                                                            "        // Method call with argument\n" +
                                                            "        greetUser(\"John\");\n" +
                                                            "    }\n" +
                                                            "}\n" +
                                                            "Return Statement: Methods can return a value using the return statement.\n" +
                                                            "\n" +
                                                            "Example Java Code:\n" +
                                                            "\n" +
                                                            "public class Calculator {\n" +
                                                            "    // Method declaration\n" +
                                                            "    public static int addNumbers(int a, int b) {\n" +
                                                            "        return a + b;\n" +
                                                            "    }\n" +
                                                            "\n" +
                                                            "    // Main method\n" +
                                                            "    public static void main(String[] args) {\n" +
                                                            "        // Method call with arguments\n" +
                                                            "        int result = addNumbers(5, 7);\n" +
                                                            "        System.out.println(\"Sum: \" + result);\n" +
                                                            "    }\n" +
                                                            "}")
                                            )), new HashSet<>(getHtmlQuizzes())
                            ),
                    new Course
                            (
                                    "Go Programming",
                                    "go.png",
                                    "Elevate your programming skills with this comprehensive Golang course designed for both beginners and experienced developers seeking to enhance their proficiency. Delve into the elegant design.",
                                    new LinkedHashSet<>(
                                            List.of(
                                                    new Lesson("Introduction to Go Programming", "Go, often referred to as Golang, is a statically typed, compiled language designed for simplicity and efficiency. Here are some key concepts:\n" +
                                                            "\n" +
                                                            "Hello, World!: The traditional first program in any programming language is \"Hello, World!\" In Go, it looks like this:\n" +
                                                            "\n" +
                                                            "package main\n" +
                                                            "\n" +
                                                            "import \"fmt\"\n" +
                                                            "\n" +
                                                            "func main() {\n" +
                                                            "    fmt.Println(\"Hello, World!\")\n" +
                                                            "}\n" +
                                                            "Structure of a Go Program:\n" +
                                                            "\n" +
                                                            "package main: Declares that this Go file belongs to the main package.\n" +
                                                            "import \"fmt\": Imports the fmt package for formatted I/O.\n" +
                                                            "func main() { ... }: The main function where program execution begins.\n" +
                                                            "fmt.Println(): A function to print output.\n" +
                                                            "Compile and Run: Save the code in a file (e.g., hello.go) and run the following commands:\n" +
                                                            "\n" +
                                                            "go run hello.go"), new Lesson("Go Functions and Parameters", "Functions in Go allow you to organize code into reusable blocks. Here are some key concepts:\n" +
                                                            "\n" +
                                                            "Function Declaration and Definition:\n" +
                                                            "\n" +
                                                            "Declaration: func functionName(parameters) returnType { ... }\n" +
                                                            "Definition:\n" +
                                                            "func functionName(parameters) returnType {\n" +
                                                            "    // Function body\n" +
                                                            "}\n" +
                                                            "Parameters and Arguments:\n" +
                                                            "\n" +
                                                            "Functions can take parameters, which act as variables inside the function.\n" +
                                                            "Example:\n" +
                                                            "package main\n" +
                                                            "\n" +
                                                            "import \"fmt\"\n" +
                                                            "\n" +
                                                            "// Function declaration\n" +
                                                            "func greetUser(name string) {\n" +
                                                            "    fmt.Println(\"Hello,\", name+\"!\")\n" +
                                                            "}\n" +
                                                            "\n" +
                                                            "// Main function\n" +
                                                            "func main() {\n" +
                                                            "    // Function call with argument\n" +
                                                            "    greetUser(\"John\")\n" +
                                                            "}\n" +
                                                            "Return Statement: Functions can return a value using the return statement.\n" +
                                                            "\n" +
                                                            "Example Go Code:\n" +
                                                            "\n" +
                                                            "package main\n" +
                                                            "\n" +
                                                            "import \"fmt\"\n" +
                                                            "\n" +
                                                            "// Function declaration\n" +
                                                            "func addNumbers(a, b int) int {\n" +
                                                            "    return a + b\n" +
                                                            "}\n" +
                                                            "\n" +
                                                            "// Main function\n" +
                                                            "func main() {\n" +
                                                            "    // Function call with arguments\n" +
                                                            "    result := addNumbers(5, 7)\n" +
                                                            "    fmt.Println(\"Sum:\", result)\n" +
                                                            "}")
                                            )), new HashSet<>(getHtmlQuizzes())
                            ));
            courseRepository.saveAll(courses);
        };
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return email -> repository.findUserByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
