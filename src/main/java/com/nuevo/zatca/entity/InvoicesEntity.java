package com.nuevo.zatca.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "invoices")
public class InvoicesEntity {

    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid")
    private UUID id;


    @Column(name = "invoice_number", nullable = false, unique = true)
    private String invoiceNumber;

    @Column(name = "invoice_type")
    private String invoiceType;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "invoice_time")
    private LocalTime invoiceTime;

    @Column(name = "issue_datetime_gregorian")
    private OffsetDateTime issueDatetimeGregorian;

    @Column(name = "issue_datetime_hijri")
    private String issueDatetimeHijri;

    @Column(name = "currency_code")
    private String currencyCode;

    @Column(name = "payment_means")
    private String paymentMeans;

    @Column(name = "payment_terms")
    private String paymentTerms;

    @Column(name = "exchange_rate")
    private BigDecimal exchangeRate;

    @Column(name = "net_total")
    private BigDecimal netTotal;

    @Column(name = "vat_total")
    private BigDecimal vatTotal;

    @Column(name = "gross_total")
    private BigDecimal grossTotal;

    @Column(name = "discount_amount")
    private BigDecimal discountAmount;

    @Column(name = "withholding_tax_amount")
    private BigDecimal withholdingTaxAmount;

    @Column(name = "pre_tax_total")
    private BigDecimal preTaxTotal;

    @Column(name = "round_off_amount")
    private BigDecimal roundOffAmount;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name = "delivery_location")
    private String deliveryLocation;

    @Column(name = "delivery_terms")
    private String deliveryTerms;

    @Column(name = "document_currency_code")
    private String documentCurrencyCode;

    @Column(name = "tax_currency_code")
    private String taxCurrencyCode;

    @Column(name = "zatca_status")
    private String zatcaStatus;

    @Column(name = "zatca_uuid", columnDefinition = "uuid")
    private UUID zatcaUuid;

    @Column(name = "zatca_hash", columnDefinition = "TEXT")
    private String zatcaHash;

    @Column(name = "zatca_qr_code", columnDefinition = "TEXT")
    private String zatcaQrCode;

    @Column(name = "zatca_previous_invoice_hash", columnDefinition = "TEXT")
    private String zatcaPreviousInvoiceHash;

    @Column(name = "zatca_error_code")
    private String zatcaErrorCode;

    @Column(name = "zatca_error_message", columnDefinition = "TEXT")
    private String zatcaErrorMessage;

    @Column(name = "zatca_request_payload", columnDefinition = "jsonb")
    private String zatcaRequestPayload;

    @Column(name = "zatca_response_payload", columnDefinition = "jsonb")
    private String zatcaResponsePayload;

    @Column(name = "is_cancellable")
    private Boolean isCancellable;

    @Column(name = "cancellation_reason", columnDefinition = "TEXT")
    private String cancellationReason;

    // Relationships
    @ManyToOne
    @JoinColumn(name = "reference_invoice_id")
    private InvoicesEntity referenceInvoice;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomersEntity customer;

    @ManyToOne
    @JoinColumn(name = "created_by_user_id")
    private TenantUsersEntity createdByUser;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        setCreatedAt(OffsetDateTime.now());
        setUpdatedAt(OffsetDateTime.now());
    }

    @PreUpdate
    protected void onUpdate() {
        setUpdatedAt(OffsetDateTime.now());
    }

}
