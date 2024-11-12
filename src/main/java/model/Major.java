package model;

// This is to list the different majors so that we can choose from
public enum Major {
    CS("Computer Science"),
    CPIS("Computer Information Systems"),
    ENGLISH("English");

    private final String displayName; // this stores the name of the major so that it can show

    // This is to set up each major with its display name
    Major(String displayName) {
        this.displayName = displayName;
    }

    // This changes the toString to show the display name of the major
    @Override
    public String toString() {
        return this.displayName;
    }
}
