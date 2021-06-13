package com.org.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.org.entities.FeedBack;
import com.org.repository.IFeedBackRepository;
@Service
@Transactional
public class IFeedbackServiceImpl implements IFeedBackService{
	@Autowired
	private IFeedBackRepository FeedBack_Repository;
	
	/*
	 * Add Feedback
	 */
	@Override
	public FeedBack addFeedBack(FeedBack feedback) {
		// TODO Auto-generated method stub
		return FeedBack_Repository.save(feedback);
	}
	/*
	 * Update Feedback
	 */
	@Override
	public FeedBack updateFeedBack(FeedBack feedback) {
		// TODO Auto-generated method stub
		return FeedBack_Repository.save(feedback);
	}
	/*
	 * Get Feedback
	 */
	@Override
	public FeedBack getFeedBackDetailsById(int feedbackId) throws Exception {
		// TODO Auto-generated method stub
		return FeedBack_Repository.findById(feedbackId).orElseThrow(() -> new Exception("Element no Found"));
	}
	/*
	 * Delete Feedback
	 */
	@Override
	public void deleteFeedBackById(int feedbackId) {
		// TODO Auto-generated method stub
		FeedBack_Repository.deleteById(feedbackId);
	}

}
