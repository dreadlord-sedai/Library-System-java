package lk.jiat.neolibrary.entity;

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
