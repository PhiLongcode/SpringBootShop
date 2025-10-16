package gduK17.shop.domain.entity;

import java.util.Objects;

public abstract class Entity {

    public Entity() {
        // Constructor mặc định
    }

    public abstract boolean isEmpty();

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        // Tương tự Equatable: so sánh dựa trên props
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        return Objects.equals(getProps(), ((Entity) obj).getProps());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProps());
    }

    // Hàm tương đương props trong Dart
    protected Object[] getProps() {
        return new Object[0];
    }
}
