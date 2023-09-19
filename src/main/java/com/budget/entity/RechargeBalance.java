package com.budget.entity;

import com.budget.enums.CompanyEnum;
import com.budget.enums.TypeRecharge;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "recharge_balance")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RechargeBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_movement")
    private Movement movement;

    @Enumerated(EnumType.STRING)
    private CompanyEnum company;

    @Column(name = "type_charge")
    @Enumerated(EnumType.STRING)
    private TypeRecharge typeRecharge;

    private Double revenue;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RechargeBalance that = (RechargeBalance) o;
        return Objects.equals(id, that.id) && Objects.equals(movement, that.movement) && company == that.company && typeRecharge == that.typeRecharge && Objects.equals(revenue, that.revenue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, movement, company, typeRecharge, revenue);
    }

    @Override
    public String toString() {
        return "RechargeBalance{" +
                "id=" + id +
                ", movement=" + movement +
                ", company=" + company +
                ", typeRecharge=" + typeRecharge +
                ", revenue=" + revenue +
                '}';
    }
}
