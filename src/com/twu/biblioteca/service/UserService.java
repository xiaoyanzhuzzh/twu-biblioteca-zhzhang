package com.twu.biblioteca.service;

import com.twu.biblioteca.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    public List<User> initUsers() {

        List<User> users = new ArrayList<User>();
        users.add(new User("zhzhang", "1111", "customer"));
        users.add(new User("yanzi", "1111", "librarian"));
        users.add(new User("xueqian", "1111", "librarian"));

        return users;
    }

    public User userLogin(User user, List<User> users) {

        User result = null;
        for(User aUser: users) {
            if(aUser.getName().equals(user.getName()) && aUser.getPassword().equals(user.getPassword())) {
                result = aUser;
                break;
            }
        }
        return result;
    }

    public String showCustomerInformation(User customer) {
        return "Name: " + customer.getName() + "\n" +
                "Email: \n" +
                "PhoneNumber: \n";
    }

    public List<User> showCustomersWithBorrowedBooks(List<User> users) {

        List<User> customers = this.getCustomers(users);

        List<User> customerWithBorrowedBooks = new ArrayList<User>();

        for (User customer : customers) {

            if (customer.getBorrowedBooks().size() != 0) {

                customerWithBorrowedBooks.add(customer);
            }
        }
        return customerWithBorrowedBooks;
    }

    private List<User> getCustomers(List<User> users) {

        List<User> customers = new ArrayList<User>();

        for(User user: users) {

            if(user.getType().equals("customer")) {

                customers.add(user);
            }
        }
        return customers;
    }
}
