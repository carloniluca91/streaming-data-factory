package it.luca.data.model.jarvis;

import it.luca.data.annotation.RandomNumber;
import it.luca.data.annotation.RandomValue;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JarvisCiclo {

    @RandomValue(values = {"G-1", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"})
    private String cicloDiRiferimento;

    @RandomNumber(min = -100000, max = 100000, as = Double.class)
    private Double rinominaEnergia;

    private final String unitaDiMisuraRinominaEnergia = "KWH";

    @RandomNumber(min = -100000, max = 100000, as = Double.class)
    private Double limiteMinimoEnergia;

    private final String unitaDiMisuraLimiteMinimoEnergia = "KWH";

    @RandomNumber(min = -100000, max = 100000, as = Double.class)
    private Double limiteMassimoEnergia;

    private final String unitaDiMisuraLimiteMassimoEnergia = "KWH";
}
