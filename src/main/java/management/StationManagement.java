package management;

import exception.NoExistStationNameException;
import exception.NoneFunctionException;
import exception.NullRepositoryException;
import input.Input;
import subway.domain.Station;
import subway.domain.StationRepository;

public class StationManagement {
    public final static String ENROLL_STATION_NAME = "등록할 역 이름을 입력하세요.";
    public final static String DELETE_STATION_NAME = "삭제할 역 이름을 입력하세요.";
    public final static String INFO = "[INFO] ";

    public static void stationManagement(String answer, Input input){
        if(answer.equals("1")){
            insert(input);
        }else if(answer.equals("2")){
            delete(input);
        } else if(answer.equals("3")){
            allList();
        } else if(answer.equals("B")){
            //
        } else{
            makeException();
        }
    }

    private static void insert(Input input){
        System.out.println(ENROLL_STATION_NAME);
        StationRepository.addStation(new Station(input.inputStationName()));
    }

    private static void delete(Input input){
        System.out.println(DELETE_STATION_NAME);
        if(!StationRepository.deleteStation(input.inputStationName())){
            throw new NoExistStationNameException();
        }
    }

    private static void allList(){
        //리스트가 없으면 말해주기
        if(StationRepository.stations().size() == 0){
            throw new NullRepositoryException();
        }
        for(Station station : StationRepository.stations()){
            System.out.println(INFO + station.getName());
        }
        System.out.println();
    }

    private static void makeException(){
        throw new NoneFunctionException();
    }
}
