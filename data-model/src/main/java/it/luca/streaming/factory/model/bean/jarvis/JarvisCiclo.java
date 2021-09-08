package it.luca.streaming.factory.model.bean.jarvis;

import it.luca.data.factory.annotation.RandomNumber;
import it.luca.data.factory.annotation.RandomValue;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JarvisCiclo {

    @RandomValue(useClasspathLocator = true)
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
