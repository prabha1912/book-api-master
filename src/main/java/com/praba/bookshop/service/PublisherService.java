package com.praba.bookshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praba.bookshop.model.Address;
import com.praba.bookshop.model.Publisher;
import com.praba.bookshop.repository.AddressDao;
import com.praba.bookshop.repository.PublisherDao;
import com.praba.bookshop.service.exceptions.AddressNotFoundException;
import com.praba.bookshop.service.exceptions.PublisherNotFoundException;

@Service
public class PublisherService {
	@Autowired
	private PublisherDao publisherDao;
	@Autowired
	private AddressDao addressDao;

	@Autowired
	public PublisherService(PublisherDao publisherDao) {
		super();
		this.publisherDao = publisherDao;
	}
	
	public Publisher save(Publisher publisher) {
		return publisherDao.save(publisher);
	}
	
	public List<Publisher> findAll() {
		return publisherDao.findAll();
	}

	public void delete(int id) {
		publisherDao.deleteById(id);
	}

	public Publisher findById(int id) {
		Optional<Publisher> publisher = publisherDao.findById(id);
		if (publisher.isEmpty()) {
			throw new PublisherNotFoundException("Publisher with id of " + id + " was not found");
		}
		return publisher.get();
	}

	public Publisher addPublisherToAddress(Publisher publisher) {
		Optional<Address> address = addressDao.findById(publisher.getAddress().getAddressId());
		if (address.isEmpty()) {
			throw new AddressNotFoundException("Address with id of " + publisher.getAddress().getAddressId() + " was not found");
		}
		publisher.setAddress(address.get());
		return publisherDao.save(publisher);
	}
}
