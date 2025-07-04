package lk.jiat.neolibrary.entity;

public enum UserStatus {
     ACTIVE(1), INACTIVE(2);

    private final int id;

    UserStatus(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
