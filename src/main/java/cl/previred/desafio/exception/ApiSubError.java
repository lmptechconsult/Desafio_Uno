package cl.previred.desafio.exception;

import java.util.Objects;

public class ApiSubError {

	class ApiValidationError extends ApiSubError {
		
		   private String object;
		   private String field;
		   private Object rejectedValue;
		   private String message;

		   ApiValidationError(String object, String message) {
		       this.object = object;
		       this.message = message;
		   }

		public String getObject() {
			return object;
		}

		public void setObject(String object) {
			this.object = object;
		}

		public String getField() {
			return field;
		}

		public void setField(String field) {
			this.field = field;
		}

		public Object getRejectedValue() {
			return rejectedValue;
		}

		public void setRejectedValue(Object rejectedValue) {
			this.rejectedValue = rejectedValue;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + Objects.hash(field, message, object, rejectedValue);
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ApiValidationError other = (ApiValidationError) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			return Objects.equals(field, other.field) && Objects.equals(message, other.message)
					&& Objects.equals(object, other.object) && Objects.equals(rejectedValue, other.rejectedValue);
		}

		@Override
		public String toString() {
			return "ApiValidationError [object=" + object + ", field=" + field + ", rejectedValue=" + rejectedValue
					+ ", message=" + message + "]";
		}

		private ApiSubError getEnclosingInstance() {
			return ApiSubError.this;
		}
		   
	}
}
