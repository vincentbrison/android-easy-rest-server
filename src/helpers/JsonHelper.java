package helpers;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;



public class JsonHelper {

	private static JsonHelper instence;
	private static ObjectMapper sMapper;

	private JsonHelper() {
		
		// Configure the mapper.
		sMapper = new ObjectMapper();
		sMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.NONE);
        sMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        sMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
	}

	public static JsonHelper getInstence() {
		if (instence == null) {
			instence = new JsonHelper();
		}
		return instence;
	}


	/**
	 * Encode an object into string.
	 *
	 * @param object is the object to convert to json.
	 * @return the object in json format.
	 */
	public String toJson(Object object) {
		try {
			return sMapper.writeValueAsString(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Convert the json string into an object.
	 *
	 * @param objectString is the json string to convert.
	 * @param clazz        is the class of the object to recreate.
	 * @param <T>          is the class of the object to recreate.
	 * @return the object recreated.
	 */
	public <T> T fromJson(String objectString, Class<T> clazz) {
		try {
			return clazz.cast(sMapper.readValue(objectString, clazz));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Close an object.
	 * @param objectToClone is the object to clone.
	 * @param clazz is the class of the object to clone.
	 * @param <T> is the class of the object to clone.
	 * @return the cloned object.
	 */
	public <T> T clone(T objectToClone, Class<T> clazz) {
		return fromJson(toJson(objectToClone), clazz);
	}
}
