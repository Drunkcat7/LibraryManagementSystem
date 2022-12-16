package entity;

public class MenuData {
    String title;
    String className;

    public MenuData(String title, String className) {
        this.title = title;
        this.className = className;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
