package latihan.latihan.exception;

import java.io.Serializable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Created by Fahmy Abida Email : fahmyabida@gmail.com */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public final class ResourceNotFound extends RuntimeException implements Serializable {
  private String resourceName;
  private String fieldName;
  private Object fieldValue;

  public ResourceNotFound(String resourceName, String fieldName, Object fieldValue) {
    super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
    this.resourceName = resourceName;
    this.fieldName = fieldName;
    this.fieldValue = fieldValue;
  }

  public String getResourceName() {
    return resourceName;
  }

  public String getFieldName() {
    return fieldName;
  }

  public Object getFieldValue() {
    return fieldValue;
  }
}
