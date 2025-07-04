package lk.jiat.zlibrary.entity;

public enum UserRole {
    ADMIN(1), LIBRARIAN(2);

    private final int id;

    UserRole(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
