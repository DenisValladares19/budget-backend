package com.budget.entity;

import com.budget.enums.TypeMovement;
import com.budget.enums.TypeTransaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "movements")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double currentAmount;
    private Double amount;

    @Column(name = "type_transaction")
    @Enumerated(EnumType.STRING)
    private TypeTransaction typeTransaction;

    @Column(name = "type_movement")
    @Enumerated(EnumType.STRING)
    private TypeMovement typeMovement;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movement movement = (Movement) o;
        return Objects.equals(id, movement.id) && Objects.equals(currentAmount, movement.currentAmount) && Objects.equals(amount, movement.amount) && typeTransaction == movement.typeTransaction && typeMovement == movement.typeMovement && Objects.equals(user, movement.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, currentAmount, amount, typeTransaction, typeMovement, user);
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", currentAmount=" + currentAmount +
                ", amount=" + amount +
                ", typeTransaction=" + typeTransaction +
                ", typeMovement=" + typeMovement +
                ", user=" + user +
                '}';
    }
}
