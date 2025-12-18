@Service
public class DeliveryRecordServiceImpl implements DeliveryRecordService {

    private final DeliveryRecordRepository deliveryRecordRepository;
    private final ContractRepository contractRepository;

    public DeliveryRecordServiceImpl(DeliveryRecordRepository deliveryRecordRepository,
                                     ContractRepository contractRepository) {
        this.deliveryRecordRepository = deliveryRecordRepository;
        this.contractRepository = contractRepository;
    }

    @Override
    public List<DeliveryRecord> getDeliveriesByContractId(Long contractId) {
        return contractRepository.findById(contractId)
                .map(deliveryRecordRepository::findByContract)
                .orElse(List.of());   // ✅ NO EXCEPTION
    }

    @Override
    public DeliveryRecord getLatestDelivery(Long contractId) {
        return contractRepository.findById(contractId)
                .map(deliveryRecordRepository::findTopByContractOrderByDeliveryDateDesc)
                .orElse(null);        // ✅ NO EXCEPTION
    }
}
