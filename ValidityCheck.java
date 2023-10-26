import java.util.List;

public interface ValidityCheck {
    boolean isValid(String number);
    List<String> getErrors();
}

