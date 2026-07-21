class ParkingSystem {
public:
    vector<int> parking;

    ParkingSystem(int big, int medium, int small) {
        parking = {0, big, medium, small};
    }

    bool addCar(int carType) {
        if (parking[carType] > 0) {
            parking[carType]--;
            return true;
        }

        return false;
    }
};
