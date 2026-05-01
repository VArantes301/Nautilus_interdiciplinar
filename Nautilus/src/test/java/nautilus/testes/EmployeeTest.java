//teste para ver se a classe employee esta funcionanando

package nautilus.testes;

import nautilus.models.Employee;
import nautilus.enums.EnumEmp;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {

    @Test
    void EmployeeValid() {
        Employee Jimmy = new Employee(
                "Jimmy Silva",
                "12345678901",
                "123456789",
                EnumEmp.EnumEmpl.MEDICO,
                "MAT001",
                "01/01/1990",
                "senha123"
        );

        assertEquals("Jimmy Silva", Jimmy.getNome()); // nome retornou normal ✅
        assertEquals("12345678901", Jimmy.getCpf()); // cpf retornou normal ✅
        assertEquals("123456789", Jimmy.getRg()); // rg retornou normal ✅
        assertEquals("01/01/1990", Jimmy.getDataNasc()); // data de nascimento retornou normal ✅
        assertEquals("MAT001", Jimmy.getMatricula()); // matricula retornou normal ✅
        assertTrue(Jimmy.verificarSenha("senha123")); // senha certa retornou normal ✅
        assertFalse(Jimmy.verificarSenha("senhaErrada")); // senha errada retornou normal ✅
    }

    @Test
    void EmployeeInvalid() {
        assertThrows(IllegalArgumentException.class, () ->new Employee(
                "Jimmy Silva", //encontra excessão de nome ✅
                "12345678901", //encontra excessão de cpf ✅
                "123456789", //encontra excessão de rg ✅
                EnumEmp.EnumEmpl.MEDICO,
                "MAT001", //encontra excessão de matricula ✅
                "01/01/1990", //encontra execssão para valores != LocalDate e acima de LocalDate.now() ✅
                "s" //encontra excessão de senha ✅
        ));
    }
}