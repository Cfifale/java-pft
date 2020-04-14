package ru.stqa.pft.mantis.appmanager;

import org.openqa.selenium.By;

import java.util.List;

public class PasswordResetHelper extends HelperBase{

    public PasswordResetHelper(ApplicationManager app) {
        super(app);
    }

    public void login(String username, String password) {
        wd.get(app.getProperty("web.baseUrl") + "/login.php");
        type(By.name("username"), username);
        click(By.cssSelector("input[value='Войти']"));
        type(By.name("password"), password);
        click(By.cssSelector("input[value='Войти']"));
    }

    public void reset(String username) {
        click(By.cssSelector("a[href $= 'manage_overview_page.php']"));
        click(By.cssSelector("a[href $= 'manage_user_page.php']"));
        click(By.linkText(username));
        click(By.cssSelector("input[value='Сбросить пароль']"));
        click(By.cssSelector(".btn-round"));
    }

    public void logout() {
        click(By.cssSelector(".user-info"));
        click(By.cssSelector(".fa-sign-out"));
    }

    public void finish(String confirmationLink, String password) {
        wd.get(confirmationLink);
        type(By.name("password"), password);
        type(By.name("password_confirm"), password);
        click(By.cssSelector(".bigger-110"));
    }
}
