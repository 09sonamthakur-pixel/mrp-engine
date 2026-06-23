package dto;

public class BomLinkDto {
    private Long parentItemId;
    private Long childItemId;
    private Integer quantityPer;

    public BomLinkDto() {
    }

    public BomLinkDto(Long parentItemId, Long childItemId, Integer quantityPer) {
        this.parentItemId = parentItemId;
        this.childItemId = childItemId;
        this.quantityPer = quantityPer;
    }

    public Long getParentItemId() {
        return parentItemId;
    }

    public void setParentItemId(Long parentItemId) {
        this.parentItemId = parentItemId;
    }

    public Long getChildItemId() {
        return childItemId;
    }

    public void setChildItemId(Long childItemId) {
        this.childItemId = childItemId;
    }

    public Integer getQuantityPer() {
        return quantityPer;
    }

    public void setQuantityPer(Integer quantityPer) {
        this.quantityPer = quantityPer;
    }
}
