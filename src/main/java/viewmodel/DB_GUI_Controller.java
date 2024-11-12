package viewmodel;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Person;

public class DB_GUI_Controller {

    @FXML
    private TextField first_name, last_name, department, email;

    @FXML
    private ComboBox<String> majorComboBox;

    @FXML
    private Button addBtn, editBtn, deleteBtn;

    @FXML
    private TableView<Person> tv;

    @FXML
    private TableColumn<Person, Integer> tv_id;
    @FXML
    private TableColumn<Person, String> tv_fn;
    @FXML
    private TableColumn<Person, String> tv_ln;
    @FXML
    private TableColumn<Person, String> tv_department;
    @FXML
    private TableColumn<Person, String> tv_major;

    // This sets up table columns
    @FXML
    public void initialize() {
        tv_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        tv_fn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        tv_ln.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        tv_department.setCellValueFactory(new PropertyValueFactory<>("department"));
        tv_major.setCellValueFactory(new PropertyValueFactory<>("major"));

        majorComboBox.setItems(FXCollections.observableArrayList(
                "Computer Science",
                "Computer Information Systems",
                "English"
        ));

        majorComboBox.setEditable(true);

        addBtn.setDisable(false);
    }

    // This adds a new person to the table
    @FXML
    public void addNewRecord() {
        String firstName = first_name.getText();
        String lastName = last_name.getText();
        String dept = department.getText();
        String major = majorComboBox.getValue();
        String emailAddress = email.getText();

        Person person = new Person(tv.getItems().size() + 1, firstName, lastName, dept, major, emailAddress, "");
        tv.getItems().add(person);

        first_name.clear();
        last_name.clear();
        department.clear();
        majorComboBox.setValue(null);
        email.clear();
    }

    // This updates the person you select in the table
    @FXML
    public void editRecord() {
        Person selectedPerson = tv.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            selectedPerson.setFirstName(first_name.getText());
            selectedPerson.setLastName(last_name.getText());
            selectedPerson.setDepartment(department.getText());
            selectedPerson.setMajor(majorComboBox.getValue());
            selectedPerson.setEmail(email.getText());
            tv.refresh();
        }
    }

    // This removes the person you select from the table
    @FXML
    public void deleteRecord() {
        Person selectedPerson = tv.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            tv.getItems().remove(selectedPerson);
        }
    }

    @FXML
    public void selectedItemTV() {
        Person selectedPerson = tv.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            editBtn.setDisable(false);
            deleteBtn.setDisable(false);
            first_name.setText(selectedPerson.getFirstName());
            last_name.setText(selectedPerson.getLastName());
            department.setText(selectedPerson.getDepartment());
            majorComboBox.setValue(selectedPerson.getMajor());
            email.setText(selectedPerson.getEmail());
        }
    }

    @FXML
    public void lightTheme() {
        // This is to switch to light theme
    }

    @FXML
    public void darkTheme() {
        // This is to switch to dark theme
    }

    @FXML
    public void exportCSV() {
    }

    @FXML
    public void importCSV() {
    }
}
