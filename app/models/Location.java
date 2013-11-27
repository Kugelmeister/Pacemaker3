package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import play.db.ebean.Model;

import com.google.common.base.Objects;

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
  
  public String toString()
  {
    return Objects.toStringHelper(this)
        .add("Latitude", latitude)
        .add("Longitude", longitude).toString();
  }
}
