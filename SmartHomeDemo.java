interface SmartDevice {
    void turnOn();
    void turnOff();
}

class SmartFan implements SmartDevice {
    private int speed;

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void turnOn() {
        System.out.println("Smart Fan is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Fan is turned OFF.");
    }
}

class SmartLight implements SmartDevice {
    private int brightness;

    public void setBrightness(int level) {
        this.brightness = level;
    }

    @Override
    public void turnOn() {
        System.out.println("Smart Light is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart Light is turned OFF.");
    }
}

class SmartAC implements SmartDevice {
    private int temperature;

    public void setTemperature(int temp) {
        this.temperature = temp;
    }

    @Override
    public void turnOn() {
        System.out.println("Smart AC is turned ON.");
    }

    @Override
    public void turnOff() {
        System.out.println("Smart AC is turned OFF.");
    }
}

public class SmartHomeDemo {
    public static void main(String[] args) {
        SmartDevice device;

        device = new SmartFan();
        device.turnOn();
        device.turnOff();

        System.out.println();

        device = new SmartLight();
        device.turnOn();
        device.turnOff();

        System.out.println();

        device = new SmartAC();
        device.turnOn();
        device.turnOff();
    }
}