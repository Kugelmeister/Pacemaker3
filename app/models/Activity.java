package models;

import static com.google.common.base.Objects.toStringHelper;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import play.db.ebean.Model;

@SuppressWarnings("serial")
@Entity
public class Activity extends Model
{
  @Id
  @GeneratedValue
  public Long   id;
  public String kind;
  public String location;
  public double distance;
  
  @OneToMany(cascade=CascadeType.ALL)
  public List<Location> route = new ArrayList<Location>();
  
  @Version
  public Timestamp lastUpdated;
 
  public Activity()
  {
  }
   
  public Activity(String type, String location, double distance)
  {
    this.kind      = type;
    this.location  = location;
    this.distance  = distance;
  }
  
  @Override
  public String toString()
  {
    return toStringHelper(this).addValue(id)
                               .addValue(kind)
                               .addValue(location)
                               .addValue(distance)
                               .toString();
  }
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Activity)
    {
      final Activity other = (Activity) obj;
      return Objects.equal(kind, other.kind) 
          && Objects.equal(location,  other.location)
          && Objects.equal(distance,  other.distance) ; 
    }
    else
    {
      return false;
    }
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.kind, this.location, this.distance);  
  }
  
  public static Activity findById(Long id)
  {
    return find.where().eq("id", id).findUnique();
  }
  
  public static Model.Finder<String, Activity> find = new Model.Finder<String, Activity>(String.class, Activity.class);
}
