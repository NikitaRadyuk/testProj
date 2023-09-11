package org.example.firstApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.stream.Collectors;

public class nameSurname {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Имя");
        String name = sc.nextLine();
        System.out.println("Введите Фамилию");
        String surname = sc.nextLine();

        URL url = new URL("http://localhost:8080/testProj/hello_with_name?firstName=" + name + "&lastName=" + surname);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        try(BufferedReader reader  = new BufferedReader(new InputStreamReader(con.getInputStream(), Charset.forName("utf-8")))){
            System.out.println(reader.lines().collect(Collectors.joining(System.lineSeparator())));
            if (reader.lines().collect(Collectors.joining(System.lineSeparator())) != null) {
                System.out.println(con.getResponseCode());
            }
        }
    }
}
