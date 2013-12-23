package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.google.common.base.Objects;

@SuppressWarnings("serial")
@Entity
public class Location extends Model
{
  @Id
  @GeneratedValue
  public Long id;
  
  public float latitude;
  public float longitude;
  
  public Location()
  {
  }
  
  public Location (float latitude, float longitude)
  {
    this.latitude = latitude;
    this.longitude = longitude;
  }
  
  @Override
  public boolean equals(final Object obj)
  {
    if (obj instanceof Location)
    {
      final Location other = (Location) obj;
      return Objects.equal(latitude, other.latitude) 
          && Objects.equal(longitude, other.longitude);
    }
    else
    {
      return false;
    }
  }
  
  @Override
  public String toString()
  {
    return Objects.toStringHelper(this)
        .add("Latitude", latitude)
        .add("Longitude", longitude).toString();
  }
  
  @Override  
  public int hashCode()  
  {  
     return Objects.hashCode(this.id, this.latitude, this.longitude);  
  }
  
  public static Location findById(Long id)
  {
    return find.where().eq("id", id).findUnique();
  }
  
  public static Model.Finder<String, Location> find = new Model.Finder<String, Location>(String.class, Location.class);
}
