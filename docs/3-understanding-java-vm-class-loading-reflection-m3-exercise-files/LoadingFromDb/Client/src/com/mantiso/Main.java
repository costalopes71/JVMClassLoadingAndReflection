package com.mantiso;

import com.pluralsight.IQuote;

// run with -Djava.library.path=path-to-quth-DLL (e,g, C:\demos\LoadingFromDb\Client\lib\x64

public class Main {
    public static void main(String[] args) {
        try {
            SqlServerClassLoader cl = new SqlServerClassLoader("jdbc:sqlserver://localhost\\SQLExpress;databaseName=classloading;integratedSecurity=true");
            Class clazz = cl.findClass("com.pluralsight.Quote");
            IQuote quote = (IQuote) clazz.newInstance();
            System.out.println(quote.getQuote());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
