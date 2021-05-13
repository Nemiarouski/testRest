package library;

import library.model.Book;
import library.service.BookService;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String DB_URL = "jdbc:h2:Documents/h2/database./test";
        String DB_Driver = "org.h2.Driver";

        try {
            Class.forName(DB_Driver); //Проверяем наличие JDBC драйвера для работы с БД
            Connection connection = DriverManager.getConnection(DB_URL, "adam", "!Admin26" );//соединениесБД
            System.out.println("Соединение с СУБД выполнено.");

            Statement st = null;
            st = connection.createStatement();

            ResultSet resultSet = null;
            resultSet = st.executeQuery("SELECT * FROM books");

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String author = resultSet.getString("author");
                String description = resultSet.getString("description");
                BookService bookService = new BookService();
                bookService.add(new Book(name, author, description));
                System.out.println(bookService.allBooks());
            }
            connection.close();       // отключение от БД
            System.out.println("Отключение от СУБД выполнено.");

        } catch (ClassNotFoundException e) {
            e.printStackTrace(); // обработка ошибки  Class.forName
            System.out.println("JDBC драйвер для СУБД не найден!");
        } catch (SQLException e) {
            e.printStackTrace(); // обработка ошибок  DriverManager.getConnection
            System.out.println("Ошибка SQL !");
        }
    }
}