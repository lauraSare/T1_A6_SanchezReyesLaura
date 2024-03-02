import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConversorDistancias {

  public void conversionMillas(double km, JTextField cajaResultadoM, JRadioButton millasRadio) {
    double millas = km / 1.609;

    if (millasRadio.isSelected()) {
      cajaResultadoM.setText(String.format("%.2f", millas));
    }
  }

  public void conversionPies(double km, JTextField cajaResultadoPies, JRadioButton piesRadio) {
    double pies = km * 3280.84;

    if (piesRadio.isSelected()) {
      cajaResultadoPies.setText(String.format("%.2f", pies));
    }
  }

  public void conversionPulgadas(double km, JTextField cajaResultadoPulgadas, JRadioButton pulgadasRadio) {
    double pulgadas = km * 39370.1;

    if (pulgadasRadio.isSelected()) {
      cajaResultadoPulgadas.setText(String.format("%.2f", pulgadas));
    }
  }
}

