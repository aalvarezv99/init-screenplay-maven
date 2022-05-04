package starter.utils;

import starter.models.UserLogin;

import java.util.ArrayList;
import java.util.List;

public class UserCredentials {
    public static List<UserLogin> users = new ArrayList<>();
    public static UserLogin newUser = new UserLogin();

    public static void insertUsers() {
        newUser.setTypeUser("cliente");
        newUser.setNameUser("ALMAGAS");
        newUser.setUser("userPRX-1");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("cliente");
        newUser.setNameUser("BIOMAX");
        newUser.setUser("userPRX-2");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("cliente");
        newUser.setNameUser("CHEVRON");
        newUser.setUser("userPRX-3");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("cliente");
        newUser.setNameUser("CHEVRON EXP");
        newUser.setUser("userPRX-4");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("cliente");
        newUser.setNameUser("CHILCO DISTRIBUIDORA");
        newUser.setUser("userPRX-5");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("cliente");
        newUser.setNameUser("PLEXA");
        newUser.setUser("userPRX-21");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("cliente");
        newUser.setNameUser("ROSCOGAS");
        newUser.setUser("userPRX-25");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
        newUser = new UserLogin();
        newUser.setTypeUser("planeador");
        newUser.setNameUser("PLANEADOR");
        newUser.setUser("PlannerPRX-1");
        newUser.setPassword("PrxPruebas132*");
        users.add(newUser);
    }

    public static UserLogin getUser(String typeUser, String userName) {
        return users.stream()
                .filter(item -> item.getTypeUser().equals(typeUser) && item.getNameUser().equals(userName))
                .findFirst()
                .get();
    }
}
