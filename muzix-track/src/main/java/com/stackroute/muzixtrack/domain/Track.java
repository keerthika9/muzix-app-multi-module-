package com.stackroute.muzixtrack.domain;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*import javax.persistence.Entity;*/

//@Data is like having implicit @Getter,
// @Setter, @ToString, @EqualsAndHashCode and @RequiredArgsConstructor annotations on the class
@Document(collection = "track")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Builder lets you automatically produce the code required to have your class be instantiable with code
@Builder
//@Entity annotation defines that a class can be mapped to a table.
/*@Entity*/
public class Track {
  @Id
  private int id;
  private String name;
  private String comments;

}
