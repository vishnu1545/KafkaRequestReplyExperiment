/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package se.callista.blog.avro_spring.car.avro;

import org.apache.avro.specific.SpecificData;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@SuppressWarnings("all")
@org.apache.avro.specific.AvroGenerated
public class Car extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8674845892068728494L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"Car\",\"namespace\":\"se.callista.blog.avro_spring.car.avro\",\"fields\":[{\"name\":\"VIN\",\"type\":\"string\"},{\"name\":\"plateNumber\",\"type\":[\"null\",\"string\"],\"default\":null}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<Car> ENCODER =
      new BinaryMessageEncoder<Car>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<Car> DECODER =
      new BinaryMessageDecoder<Car>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   */
  public static BinaryMessageDecoder<Car> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   */
  public static BinaryMessageDecoder<Car> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<Car>(MODEL$, SCHEMA$, resolver);
  }

  /** Serializes this Car to a ByteBuffer. */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /** Deserializes a Car from a ByteBuffer. */
  public static Car fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.CharSequence VIN;
  @Deprecated public java.lang.CharSequence plateNumber;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public Car() {}

  /**
   * All-args constructor.
   * @param VIN The new value for VIN
   * @param plateNumber The new value for plateNumber
   */
  public Car(java.lang.CharSequence VIN, java.lang.CharSequence plateNumber) {
    this.VIN = VIN;
    this.plateNumber = plateNumber;
  }

  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return VIN;
    case 1: return plateNumber;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: VIN = (java.lang.CharSequence)value$; break;
    case 1: plateNumber = (java.lang.CharSequence)value$; break;
    default: throw new org.apache.avro.AvroRuntimeException("Bad index");
    }
  }

  /**
   * Gets the value of the 'VIN' field.
   * @return The value of the 'VIN' field.
   */
  public java.lang.CharSequence getVIN() {
    return VIN;
  }

  /**
   * Sets the value of the 'VIN' field.
   * @param value the value to set.
   */
  public void setVIN(java.lang.CharSequence value) {
    this.VIN = value;
  }

  /**
   * Gets the value of the 'plateNumber' field.
   * @return The value of the 'plateNumber' field.
   */
  public java.lang.CharSequence getPlateNumber() {
    return plateNumber;
  }

  /**
   * Sets the value of the 'plateNumber' field.
   * @param value the value to set.
   */
  public void setPlateNumber(java.lang.CharSequence value) {
    this.plateNumber = value;
  }

  /**
   * Creates a new Car RecordBuilder.
   * @return A new Car RecordBuilder
   */
  public static se.callista.blog.avro_spring.car.avro.Car.Builder newBuilder() {
    return new se.callista.blog.avro_spring.car.avro.Car.Builder();
  }

  /**
   * Creates a new Car RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new Car RecordBuilder
   */
  public static se.callista.blog.avro_spring.car.avro.Car.Builder newBuilder(se.callista.blog.avro_spring.car.avro.Car.Builder other) {
    return new se.callista.blog.avro_spring.car.avro.Car.Builder(other);
  }

  /**
   * Creates a new Car RecordBuilder by copying an existing Car instance.
   * @param other The existing instance to copy.
   * @return A new Car RecordBuilder
   */
  public static se.callista.blog.avro_spring.car.avro.Car.Builder newBuilder(se.callista.blog.avro_spring.car.avro.Car other) {
    return new se.callista.blog.avro_spring.car.avro.Car.Builder(other);
  }

  /**
   * RecordBuilder for Car instances.
   */
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<Car>
    implements org.apache.avro.data.RecordBuilder<Car> {

    private java.lang.CharSequence VIN;
    private java.lang.CharSequence plateNumber;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(se.callista.blog.avro_spring.car.avro.Car.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.VIN)) {
        this.VIN = data().deepCopy(fields()[0].schema(), other.VIN);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.plateNumber)) {
        this.plateNumber = data().deepCopy(fields()[1].schema(), other.plateNumber);
        fieldSetFlags()[1] = true;
      }
    }

    /**
     * Creates a Builder by copying an existing Car instance
     * @param other The existing instance to copy.
     */
    private Builder(se.callista.blog.avro_spring.car.avro.Car other) {
            super(SCHEMA$);
      if (isValidValue(fields()[0], other.VIN)) {
        this.VIN = data().deepCopy(fields()[0].schema(), other.VIN);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.plateNumber)) {
        this.plateNumber = data().deepCopy(fields()[1].schema(), other.plateNumber);
        fieldSetFlags()[1] = true;
      }
    }

    /**
      * Gets the value of the 'VIN' field.
      * @return The value.
      */
    public java.lang.CharSequence getVIN() {
      return VIN;
    }

    /**
      * Sets the value of the 'VIN' field.
      * @param value The value of 'VIN'.
      * @return This builder.
      */
    public se.callista.blog.avro_spring.car.avro.Car.Builder setVIN(java.lang.CharSequence value) {
      validate(fields()[0], value);
      this.VIN = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'VIN' field has been set.
      * @return True if the 'VIN' field has been set, false otherwise.
      */
    public boolean hasVIN() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'VIN' field.
      * @return This builder.
      */
    public se.callista.blog.avro_spring.car.avro.Car.Builder clearVIN() {
      VIN = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'plateNumber' field.
      * @return The value.
      */
    public java.lang.CharSequence getPlateNumber() {
      return plateNumber;
    }

    /**
      * Sets the value of the 'plateNumber' field.
      * @param value The value of 'plateNumber'.
      * @return This builder.
      */
    public se.callista.blog.avro_spring.car.avro.Car.Builder setPlateNumber(java.lang.CharSequence value) {
      validate(fields()[1], value);
      this.plateNumber = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'plateNumber' field has been set.
      * @return True if the 'plateNumber' field has been set, false otherwise.
      */
    public boolean hasPlateNumber() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'plateNumber' field.
      * @return This builder.
      */
    public se.callista.blog.avro_spring.car.avro.Car.Builder clearPlateNumber() {
      plateNumber = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Car build() {
      try {
        Car record = new Car();
        record.VIN = fieldSetFlags()[0] ? this.VIN : (java.lang.CharSequence) defaultValue(fields()[0]);
        record.plateNumber = fieldSetFlags()[1] ? this.plateNumber : (java.lang.CharSequence) defaultValue(fields()[1]);
        return record;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<Car>
    WRITER$ = (org.apache.avro.io.DatumWriter<Car>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<Car>
    READER$ = (org.apache.avro.io.DatumReader<Car>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

}
