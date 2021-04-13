//package br.com.limpacity.api.service.impl;
//
//import br.com.limpacity.api.dto.ColetaQrcodeDTO;
//import br.com.limpacity.api.model.ColetaQrcodeModel;
//import br.com.limpacity.api.repository.ColetaQrcodeRepository;
//import br.com.limpacity.api.service.ColetaService;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@AllArgsConstructor
//public class ColetaServiceImpl implements ColetaService {
//
//    final ColetaQrcodeRepository coletaRepository;
//
//    @Override
//    public ColetaModel create(ColetaDTO material) {
//        return coletaRepository.save(toDto(material));
//    }
//
//    @Override
//    public ColetaQrcodeModel createQrcode(ColetaQrcodeDTO coleta) {
//
//        return null;
//    }
//
//    private static ColetaQrcodeDTO toColetaQrcode(ColetaQrcodeModel dto){
//        return ColetaQrcodeDTO.builder()
//                .uuid(dto.getUuid())
//                .nomeSolicitante(dto.getNomeSolicitante())
//                .telefone(dto.getTelefone())
//                .email(dto.getEmail())
//                .cep(dto.getCep())
//                .endereco(dto.getEndereco())
//                .numero(dto.getNumero())
//                .municipio(dto.getMunicipio())
//                .estado(dto.getEstado())
//                .pais(dto.getPais())
//                .quantidade(dto.getQuantidade())
//                .build();
//    }
//
//
//}
