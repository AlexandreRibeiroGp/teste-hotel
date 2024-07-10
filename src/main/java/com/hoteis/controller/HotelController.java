package com.hoteis.controller;

import com.hoteis.dto.HotelDto;
import com.hoteis.mapper.HotelMapper;
import com.hoteis.model.Hotel;
import com.hoteis.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value ="/api/hoteis", produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelController {

    private final HotelService hotelService;
    public final HotelMapper hotelMapper;

    @Autowired
    public HotelController(HotelService hotelService,HotelMapper hotelMapper) {
        this.hotelService = hotelService;
        this.hotelMapper = hotelMapper;
    }

    @GetMapping("/comparar")
    public ResponseEntity<List<HotelDto>> compararHoteis(
            @RequestParam(required = false) String localizacao,
            @RequestParam(required = false) BigDecimal precoMaximo,
            @RequestParam(required = false) List<String> comodidades,
            @RequestParam(required = false) Double avaliacaoMinima) {

        List<Hotel> hoteis = hotelService.compararHoteis(localizacao, precoMaximo, comodidades, avaliacaoMinima);

        List<HotelDto> hoteisDto = hoteis.stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());

        return new ResponseEntity<>(hoteisDto, HttpStatus.OK);
    }

    @PostMapping(value = "",  consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<HotelDto> criarHotel(@RequestBody HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        HotelDto novoHotelDto = hotelMapper.toDto(hotelService.criarHotel(hotel));
        return new ResponseEntity<>(novoHotelDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelDto> obterHotel(@PathVariable Long id) {
        Hotel hotel = hotelService.obterHotelPorId(id);
        if (hotel != null) {
            HotelDto hotelDto = hotelMapper.toDto(hotel);
            return new ResponseEntity<>(hotelDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<HotelDto> atualizarHotel(@PathVariable Long id, @RequestBody HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        HotelDto hotelAtualizadoDto = hotelMapper.toDto(hotelService.atualizarHotel(id, hotel));
        return new ResponseEntity<>(hotelAtualizadoDto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarHotel(@PathVariable Long id) {
        hotelService.deletarHotel(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<List<HotelDto>> pesquisarHoteis(
            @RequestParam(required = false) String destino,
            @RequestParam(required = false) LocalDate checkInDate,
            @RequestParam(required = false) LocalDate checkOutDate,
            @RequestParam(required = false) Integer numeroQuartos,
            @RequestParam(required = false) Integer numeroHospedes) {

        List<Hotel> hoteis = hotelService.pesquisarHoteis(destino, checkInDate, checkOutDate, numeroQuartos, numeroHospedes);
        List<HotelDto> hoteisDto = hoteis.stream()
                .map(hotelMapper::toDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(hoteisDto, HttpStatus.OK);
    }
}